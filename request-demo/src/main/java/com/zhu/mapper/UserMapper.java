package com.zhu.mapper;

import com.zhu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select * from tb_user where username = #{username} and #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(@Param("username") String username);

    @Insert("insert into tb_user values(null, #{username}, #{password})")
    void add(@Param("username") String username, @Param("password") String password);

}
