package com.clanner.antichat.controller.user;

import com.clanner.antichat.controller.BaseController;
import com.clanner.antichat.entity.Response;
import com.clanner.antichat.entity.Tip;
import com.clanner.antichat.entity.po.AntiUserInfo;
import com.clanner.antichat.service.UserInfoService;
import com.clanner.antichat.service.UserService;
import com.clanner.antichat.utils.Constants;
import com.clanner.antichat.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/**
 * @author Clanner
 */
@RestController
@RequestMapping(path = "/AntiChat/UserInfo")
@Scope("session")
public class UserInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;

    @PatchMapping("/modifyUserInfo")
    public Response modifyUserInfo(@RequestBody AntiUserInfo userInfo,
                                   @RequestHeader(Constants.Authorization) String token) {
        int userId = JwtUtil.getId(token);
        userInfo.setUserId(userId);
        logger.info("[modifyUserInfo] user_id：" + userId + " Param " + userInfo.toString());
        if (userInfoService.modifyUserInfo(userInfo)) {
            return message(Tip.MODIFY_USER_INFO_SUCCESS);
        } else {
            return message(Tip.MODIFY_USER_INFO_FAIL);
        }
    }

    @GetMapping("/getUserInfo")
    public Response getUserInfo(Integer userId,
                                @RequestHeader(Constants.Authorization) String token) {
        AntiUserInfo userInfo = userInfoService.getUserInfo(userId);
        if (userInfo != null) {
            if (userId == JwtUtil.getId(token)) {
                Integer modifyNum = userService.getModifyNum(userId);
                userInfo.setModifyNum(modifyNum);
            }
            return message(Tip.GET_USER_INFO_SUCCESS, userInfo);
        } else {
            return message(Tip.USER_NOT_EXIST);
        }
    }
}
