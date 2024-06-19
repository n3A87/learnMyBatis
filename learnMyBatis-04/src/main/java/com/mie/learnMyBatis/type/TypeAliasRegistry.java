package com.mie.learnMyBatis.type;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

/**
 * @author: xYLiu
 * @description 类型别名注册机
 * @date: 2024/5/1 15:36
 */

public class TypeAliasRegistry {
    private final Map<String,Class<?>> TYPE_ALIAS_MAP=new HashMap<>();

    public TypeAliasRegistry() {
        registerAlias("string",String.class);

        // 基本包装类型
        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);
    }

    public void registerAlias(String alias, Class<?> value){
        String key = alias.toLowerCase(Locale.ENGLISH);
        TYPE_ALIAS_MAP.put(key,value);
    }

    public <T> Class<T> resolveAlias(String string){
        String key = string.toLowerCase(Locale.ENGLISH);
        return (Class<T>) TYPE_ALIAS_MAP.get(key);
    }
}
