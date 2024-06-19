package com.mie.learnMyBatis.builder;

import com.mie.learnMyBatis.session.Configuration;
import com.mie.learnMyBatis.type.TypeAliasRegistry;

/**
 * @author: xYLiu
 * @description 构建器的基类，建造者模式
 * @date: 2024/4/29 19:43
 */

public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
