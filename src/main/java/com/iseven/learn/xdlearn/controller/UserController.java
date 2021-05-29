package com.iseven.learn.xdlearn.controller;

import com.iseven.learn.xdlearn.util.ResultData;
import com.iseven.learn.xdlearn.model.dto.UserDto;
import com.iseven.learn.xdlearn.model.po.User;
import com.iseven.learn.xdlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public ResultData register(@RequestBody Map<String, String> userInfo) {

        int rows = userService.save(userInfo);

        return rows == 1 ? ResultData.success() : ResultData.error("注册失败，请重试");

    }


    /**
     * 登录接口
     *
     * @param userDto
     * @return
     */
    @PostMapping("login")
    public ResultData login(@RequestBody UserDto userDto) {

        String token = userService.findByPhoneAndPwd(userDto.getPhone(), userDto.getPwd());

        return token == null ? ResultData.error("登录失败，账号密码错误") : ResultData.success(token);

    }


    /**
     * 根据用户id查询用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public ResultData findUserInfoByToken(HttpServletRequest request) {

        Integer userId = (Integer) request.getAttribute("user_id");

        if (userId == null) {
            return ResultData.error("查询失败");
        }

        User user = userService.findByUserId(userId);

        return ResultData.success(user);

    }


}
