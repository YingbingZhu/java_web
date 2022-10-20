package com.zhu.json;

import com.alibaba.fastjson2.JSONObject;

public class FastJsonDemo {
    public static void main(String[] args) {
        // java to json
        User user = new User();
        user.setId(1);
        user.setPassword("111");
        user.setUsername("222");

        String s = JSONObject.toJSONString(user);
        System.out.println(s); // {"id":1,"password":"111","username":"222"}

        // json to java
        JSONObject jsonObject = JSONObject.parseObject("{\"id\":1,\"password\":\"111\",\"username\":\"222\"}");
        System.out.println(jsonObject);


    }
}
