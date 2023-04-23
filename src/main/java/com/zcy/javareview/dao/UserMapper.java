package com.zcy.javareview.dao;

import com.zcy.javareview.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zcy
 * @version 1.0.0
 * @date 2023/3/21 10:56
 * @description:
 */
@Mapper
public interface UserMapper {

    /**
     * @description: rrrr
     * @author: zcy
     * @date: 2023/3/21 15:44
     * @param: id
     * @return: int
     **/
    int deleteByPrimaryKey(@Param("id") Integer id);

    /**
     * @description:
     * @author: zcy
     * @date: 2023/3/21 15:45
     * @param: row
     * @return: int
     **/
    int insert(User row);

    /**
     * @description:
     * @author: zcy
     * @date: 2023/3/21 15:45
     * @param: row
     * @return: int
     **/
    int insertSelective(User row);

    /**
     * @description:
     * @author: zcy
     * @date: 2023/3/21 15:45
     * @param: id
     * @return: com.zcy.javareview.entity.User
     **/
    User selectByPrimaryKey(Integer id);

    /**
     * @description:
     * @author: zcy
     * @date: 2023/3/21 15:45
     * @param: row
     * @return: int
     **/
    int updateByPrimaryKeySelective(User row);

    /**
     * @description:
     * @author: zcy
     * @date: 2023/3/21 15:45
     * @param: row
     * @return: int
     **/
    int updateByPrimaryKey(User row);
}