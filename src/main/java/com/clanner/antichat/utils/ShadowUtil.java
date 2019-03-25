package com.clanner.antichat.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Clanner
 * 密码(及算法)工具类
 */
public class ShadowUtil {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final BigInteger e = new BigInteger("65537");

    private static final BigInteger getHugePrime() {
        return BigInteger.probablePrime(1024, new Random());
    }

    private static BigInteger[] extGcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            BigInteger x1 = BigInteger.ONE;
            BigInteger y1 = BigInteger.ZERO;
            BigInteger x = x1;
            BigInteger y = y1;
            BigInteger r = a;
            BigInteger[] result = {r, x, y};
            return result;
        } else {
            BigInteger[] temp = extGcd(b, a.mod(b));
            BigInteger r = temp[0];
            BigInteger x1 = temp[1];
            BigInteger y1 = temp[2];

            BigInteger x = y1;
            BigInteger y = x1.subtract(a.divide(b).multiply(y1));
            BigInteger[] result = {r, x, y};
            return result;
        }
    }

    private static BigInteger expMode(BigInteger base, BigInteger exponent, BigInteger n) {
        char[] binaryArray = new StringBuilder(exponent.toString(2)).reverse().toString().toCharArray();
        int r = binaryArray.length;
        List<BigInteger> baseArray = new ArrayList<BigInteger>();

        BigInteger preBase = base;
        baseArray.add(preBase);
        for (int i = 0; i < r - 1; i++) {
            BigInteger nextBase = preBase.multiply(preBase).mod(n);
            baseArray.add(nextBase);
            preBase = nextBase;
        }
        BigInteger a_w_b = multi(baseArray.toArray(new BigInteger[baseArray.size()]), binaryArray, n);
        return a_w_b.mod(n);
    }

    private static BigInteger multi(BigInteger[] array, char[] bin_array, BigInteger n) {
        BigInteger result = BigInteger.ONE;
        for (int index = 0; index < array.length; index++) {
            BigInteger a = array[index];
            if (bin_array[index] == '0') {
                continue;
            }
            result = result.multiply(a);
            result = result.mod(n);
        }
        return result;
    }

    private static boolean genKeyCore(BigInteger[] result) {
        BigInteger p = getHugePrime();
        BigInteger q = getHugePrime();
        BigInteger n = p.multiply(q);
        BigInteger fy = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger a = e;
        BigInteger b = fy;
        BigInteger[] rxy = extGcd(a, b);
        BigInteger r = rxy[0];
        BigInteger x = rxy[1];
        BigInteger y = rxy[2];

        BigInteger d = x;
        result[0] = n;
        result[1] = d;
        return d.compareTo(BigInteger.ZERO) < 1;
    }

    public static BigInteger[] genKey() {
        BigInteger[] genKey = new BigInteger[2];
        while (genKeyCore(genKey)) ;
        return genKey;
    }

    /**
     * 加密
     */
    public static BigInteger encrypt(String str, BigInteger pubKey) {
        BigInteger m = new BigInteger(string2number(str));
        BigInteger c = expMode(m, e, pubKey);
        return c;
    }

    /**
     * 解密
     */
    public static BigInteger decrypt(BigInteger c, BigInteger priKey, BigInteger pubKey) {
        long start = System.currentTimeMillis();
        BigInteger m = expMode(c, priKey, pubKey);
        System.out.println("解密耗时：" + (System.currentTimeMillis() - start) + "毫秒");
        return m;
    }

    /**
     * MD5摘要
     */
    public static String MD5(String str) {
        // 加密之后所得字节数组
        byte[] bytes = encryptionStrBytes(string2number(str), "MD5");
        return bytesConvertToHexString(bytes);
    }

    public static String SHA1(String str) {
        byte[] bytes = encryptionStrBytes(str, "SHA1");
        return getFormattedText(bytes);
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    private static byte[] encryptionStrBytes(String str, String algorithm) {
        // 加密之后所得字节数组
        byte[] bytes = null;
        try {
            // 获取MD5算法实例 得到一个md5的消息摘要
            MessageDigest md = MessageDigest.getInstance(algorithm);
            //添加要进行计算摘要的信息
            md.update(str.getBytes());
            //得到该摘要
            bytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("加密算法: " + algorithm + " 不存在: ");
        }
        return null == bytes ? null : bytes;
    }

    private static String bytesConvertToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
            String s = Integer.toHexString(0xff & aByte);
            if (s.length() == 1) {
                sb.append("0" + s);
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static final String string2number(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            builder.append((int) str.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String pubSalt = "f7SAUqmRcXqqHNe3LlY5BcBx2H6zhMXhsmt3RedTulsOw8qJoFDw0e6y7hLZd52XiLNkyfZYIwvCJwFEsUA6TctuUXuE1HZ1iUDHgs29NLI4eDOxyJmTOonD0J95DsMp-FmbLcjamP0U8jeZlQBQzMqhCKhpdLrmf-m2LtcnQBiNXqMIZTOISbRkMklshKfr9LNrko9ZUZQVhdrY8QuJGeMhAMKugRPHXfz42nhWvriUS47jzwWvP8Z3FqbykIT6vJQxYBf6zCHrK7wE5wknji1o8-2usiIx6s5n2nf4jNy6ePL7Uv8gN81TZFopTm2XZKQ9S2iw15sGo3d_HeRmRw";String pass = "123";
        BigInteger pubKey = Base64.decodeInteger(pubSalt.getBytes());
        BigInteger tranPass = ShadowUtil.encrypt(pass, pubKey);
        System.out.println("传输的密码：" + tranPass);
    }
}
