package com.zhu.mapper;

import com.zhu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();  // selectAll is the id in UserMapper.xml

    List<User> selectById();

    /**
     *  multiple parameters can use @Param to replace arg  (array, multiple params, list, collection)
     * map.put("arg0", param1)
     * map.put("param1", param1)
     *  map.put("param2", param2)
     *  map.put("agr1", param2)
     */
    User select(@Param("username") String username, @Param("password") String password);
}
