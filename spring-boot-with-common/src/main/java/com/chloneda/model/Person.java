package com.chloneda.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author chloneda
 * @description: 抽象人的共同属性
 * @MappedSuperclass注解说明: 基于代码复用和模型分离的思想，在项目开发中使用JPA的@MappedSuperclass注解将实体类的多个属性分别封装到不同的非实体类中。
 * <p>
 * 1.@MappedSuperclass注解只能标准在类上：@Target({java.lang.annotation.ElementType.TYPE})
 * <p>
 * 2.标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中。
 * <p>
 * 3.标注为@MappedSuperclass的类不能再标注@Entity或@Table注解，也无需实现序列化接口。
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

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}
