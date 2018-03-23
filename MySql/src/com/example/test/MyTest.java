package com.example.test;

import com.example.model.User;
import com.example.utils.DataBaseUtils;

import java.util.List;

public class MyTest {
    public static void main(String... args){
        System.out.println("Hello World");
        int  a  = 3;
        System.out.println("开始连接数据库");

//        DataBaseUtils.insertUser("小安","123456");

        List<User> list = DataBaseUtils.getLocalData();
        for (User user:list){
            System.out.println("编号：" + user.getId() + ",姓名：" + user.getUsername() + "，密码：" + user.getPassword());
        }
    }
}
