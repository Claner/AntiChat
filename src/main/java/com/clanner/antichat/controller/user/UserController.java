package com.clanner.antichat.controller.user;

import com.clanner.antichat.controller.BaseController;
import com.clanner.antichat.entity.Response;
import com.clanner.antichat.entity.Tip;
import com.clanner.antichat.entity.po.AntiUser;
import com.clanner.antichat.entity.po.AntiUserInfo;
import com.clanner.antichat.service.ModuleIdService;
import com.clanner.antichat.service.UserService;
import com.clanner.antichat.service.RedisService;
import com.clanner.antichat.utils.Constants;
import com.clanner.antichat.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Clanner
 */
@RestController
@RequestMapping(path = "/AntiChat/User")
@Scope("session")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModuleIdService moduleIdService;

    @Autowired
    private RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path = "/register")
    public Response register(@RequestParam(name = "account") String account,
                             @RequestParam(name = "shadow") String shadow,
                             @RequestParam(name = "username") String username) {
        Integer userId = moduleIdService.incrementAndGetUserId();
        if (userId != null) {
            AntiUser user = userService.register(userId, account, shadow, username);
            if (user != null) {
                return message(Tip.REGISTER_SUCCESS, user);
            } else {
                return message(Tip.HAS_REGISTER);
            }
        } else {
            return message(Tip.SYSTEM_ERROR);
        }
    }

    @PostMapping(path = "/login")
    public Response login(@RequestParam(name = "account") String account,
                          @RequestParam(name = "shadow") String shadow,
                          @RequestParam(name = "mv_device") String mvDevice,
                          @RequestParam(name = "pc_device", required = false) System pcDevice,
                          HttpServletResponse httpServletResponse) {
        if (userService.freeze(account)) {
            return message(Tip.ACCOUNT_HAS_FREEZE);
        }
        AntiUserInfo userInfo = userService.login(account, shadow);
        if (userInfo != null) {
            String token = userService.createAndSetLoginInfo(userInfo.getUserId(), account, mvDevice);
            httpServletResponse.addHeader(Constants.Authorization, token);
            return message(Tip.LOGIN_SUCCESS, userInfo);
        } else {
            userService.recordLoginFail(account);
            return message(Tip.ACCOUNT_OR_PASSWORD_ERROR);
        }
    }

    @GetMapping("/logout")
    public Response logout(@RequestHeader(name = Constants.Authorization) String token) {
        Integer userId = JwtUtil.getId(token);
        userService.logout(userId);
        return message(Tip.LOGOUT_SUCCESS);
    }

    @PatchMapping("/modifyPassword")
    public Response modifyPassword(@RequestParam(name = "oldPassword") String oldPassword,
                                   @RequestParam(name = "newPassword") String newPassword,
                                   @RequestHeader(name = Constants.Authorization) String token) {
        if (userService.modifyPassword(JwtUtil.getId(token), oldPassword, newPassword)) {
            return message(Tip.MODIFY_PASSWORD_SUCCESS);
        } else {
            return message(Tip.MODIFY_PASSWORD_Fail);
        }
    }
}
