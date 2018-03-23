package com.example.utils;

import com.example.TextUtils;
import com.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtils {
    public static final String MYSQL_DREVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URI = "jdbc:mysql://localhost:3306/mydata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static List<User> getLocalData(){
        List<User> list = new ArrayList<>();
        Connection connection;
        try {
            Class.forName(MYSQL_DREVER);
            connection = DriverManager.getConnection(MYSQL_URI,"root","mysql123");
            if (!connection.isClosed()){
                System.out.println("数据库连接成功");
            }

            Statement statement = connection.createStatement();
            String sql = "select * from user";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean insertUser(String userName,String password){
        boolean isSuccess = false;
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
            return isSuccess;
        }
        Connection connection;
        try {
            Class.forName(MYSQL_DREVER);
            connection = DriverManager.getConnection(MYSQL_URI,"root","mysql123");
            if (!connection.isClosed()){
                System.out.println("数据库连接成功");
            }

            Statement statement = connection.createStatement();
            String sql = "insert into user(user_name,password) values('" + userName + "','" + password +"' )";
            isSuccess = statement.execute(sql);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
}
