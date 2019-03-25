package com.clanner.antichat.controller;

import com.clanner.antichat.entity.Response;
import com.clanner.antichat.entity.Tip;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Clanner
 */
public abstract class BaseController {

    @Autowired
    protected Response response;

    protected Response message(Tip tip) {
        response.setCode(tip.getCode());
        response.setMessage(tip.getName());
        response.setData(null);
        response.setDataList(null);
        return response;
    }

    protected Response message(Tip tip, Object object) {
        response.setCode(tip.getCode());
        response.setMessage(tip.getName());
        response.setData(object);
        response.setDataList(null);
        return response;
    }

    protected Response message(Tip tip, Object object, List<Object> list) {
        response.setCode(tip.getCode());
        response.setMessage(tip.getName());
        response.setData(object);
        response.setDataList(list);
        return response;
    }
}
