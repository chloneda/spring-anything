package com.magic.springboot.dubbo.api;

/**
 * Created by chloneda
 */
public interface IUser {

    String getFullName(String name);

    String getNickName(int id);

}
