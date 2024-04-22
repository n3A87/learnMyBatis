package com.mie.learnMyBatis.Test.dao;

/**
 * @author 3A87
 * @description
 * @date 2024/4/22
 */
public interface IStudentDao {
    String queryStudentName(String uId);

    Integer queryStudentAge(String uId);
}
