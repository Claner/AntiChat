package com.clanner.antichat.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author Clanner
 */
@Component
@Scope("prototype")
public class Response {

    private Integer code;
    private String message;
    private Object data;
    private List<Object> dataList;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }
}

