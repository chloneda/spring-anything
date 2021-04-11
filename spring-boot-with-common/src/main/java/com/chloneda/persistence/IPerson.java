package com.chloneda.persistence;

import org.springframework.data.domain.Persistable;

/**
 * @author chloneda
 * @description:
 */
public interface IPerson extends Persistable {

    void setId(String id);

    String getName();

    void setName(String name);

    String getAge();

    void setAge(String age);

    String getSex();

    void setSex(String sex);

}
