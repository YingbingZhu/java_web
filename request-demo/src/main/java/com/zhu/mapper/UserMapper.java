package com.zhu.mapper;

import com.zhu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from tb_user where username = #{username} and #{password}")
    User select(@Param("username") String username, @Param("password") String password);

}
