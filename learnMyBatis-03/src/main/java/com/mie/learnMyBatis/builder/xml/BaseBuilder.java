package com.mie.learnMyBatis.builder.xml;

import com.mie.learnMyBatis.session.Configuration;

/**
 * @author: xYLiu
 * @description 构建器的基类，建造者模式
 * @date: 2024/4/29 19:43
 */

public abstract class BaseBuilder {
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
