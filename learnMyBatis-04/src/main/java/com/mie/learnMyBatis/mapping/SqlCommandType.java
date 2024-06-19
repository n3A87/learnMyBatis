package com.mie.learnMyBatis.mapping;

/**
 * @author: xYLiu
 * @description SQL指令类型
 * @date: 2024/4/29 19:50
 */

public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
