package com.mie.learnMyBatis.Test.dao;

import com.mie.learnMyBatis.Test.po.User;

/**
 * @author o
 * @since 2024/6/19 21:02
 */
public interface IUserDao {

	User queryUserInfoById(Long uId);

}
