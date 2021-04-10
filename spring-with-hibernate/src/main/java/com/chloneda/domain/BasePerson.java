package com.chloneda.domain;

/**
 * @author chloneda
 * @description: 人物抽象接口
 */
public interface BasePerson {

    String getId();

    void setId(String id);

    String getName();

    void setName(String name);

    String getAge();

    void setAge(String age);

    String getSex();

    void setSex(String sex);

}