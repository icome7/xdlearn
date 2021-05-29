package com.iseven.learn.xdlearn.service;


import com.iseven.learn.xdlearn.model.po.User;

import java.util.Map;

public interface UserService {

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);


    String findByPhoneAndPwd(String phone, String pwd);

    User findByUserId(Integer userId);
}
