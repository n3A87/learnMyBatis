package com.mie.learnMyBatis.Test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 3A87
 * @description
 * @date 2024/4/22
 */
public class JDBCTest {
    @Test
    public void test_jdbc() throws Exception{
        //com.mysql.jdbc.Driver
        //依赖版本也要对应
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/xsxk?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();

        String sql = "select sno,sname,ssex from student";

        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("sno="+resultSet.getObject("sno")+" ");
            System.out.println("sname="+resultSet.getObject("sname")+" ");
            System.out.println("ssex="+resultSet.getObject("ssex"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
