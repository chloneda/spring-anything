package com.magic.springboot.dubbo.api;

/**
 * Created by chloneda
 */
public interface IPerson {
    String getFullName(String name);

    String getNickName(int id);
}
