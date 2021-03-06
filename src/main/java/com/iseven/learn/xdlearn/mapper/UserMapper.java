package com.iseven.learn.xdlearn.mapper;

import com.iseven.learn.xdlearn.model.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int save(User user);

    User findByPhone(@Param("phone") String phone);


    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User findByUserId(@Param("user_id") Integer userId);
}
