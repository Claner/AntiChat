package com.clanner.antichat.controller.user;

import com.clanner.antichat.controller.BaseController;
import com.clanner.antichat.entity.Response;
import com.clanner.antichat.entity.Tip;
import com.clanner.antichat.entity.po.AntiUser;
import com.clanner.antichat.entity.po.AntiUserInfo;
import com.clanner.antichat.service.ModuleIdService;
import com.clanner.antichat.service.UserService;
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
                          HttpServletResponse httpServletResponse) {
        AntiUserInfo userInfo = userService.login(account, shadow);
        if (userInfo != null) {
            String token = userService.createAndSetLoginInfo(userInfo.getUserId(), account, mvDevice);
            httpServletResponse.addHeader("Authorization", token);
            return message(Tip.LOGIN_SUCCESS, userInfo);
        } else {
            return message(Tip.ACCOUNT_OR_PASSWORD_ERROR);
        }
    }

    @PostMapping("/testLogin")
    public Response testLogin(@RequestHeader(name = "Authorization") String token) {
        System.out.println(token);
        return message(Tip.ACCOUNT_OR_PASSWORD_ERROR);
    }
}
