package com.zcy.javareview.service;

import com.zcy.javareview.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/21 10:56
 * @description:
 */

public interface UserService {

    User queryUser(@Param("id") Integer  id);

    int insertUser(User user);

}
