package com.magic.springboot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author chloneda
 * @description: 抽象人的共同属性
 */
@MappedSuperclass
public class Person implements BasePerson, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(
            name = "P_ID",
            nullable = false,
            length = 64
    )
    private String id;

    @Column(
            name = "P_NAME",
            nullable = false,
            length = 128
    )
    private String name;

    @Column(
            name = "P_AGE",
            length = 54
    )
    private String age;

    @Column(
            name = "P_SEX",
            length = 54
    )
    private String sex;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

}
