package com.chloneda.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author chloneda
 * @description: Girl实体类
 */
public class Girl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Girl的编号
     */
    private String id;

    /**
     * Girl的名称
     */
    private String name;

    /**
     * Girl的年龄
     */
    private String age;

    /**
     * Girl的家庭住址
     */
    private String address;

    /**
     * Girl的邮箱
     */
    private String email;

    /**
     * Girl的电话号码
     */
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Girl)) return false;
        Girl girl = (Girl) o;
        return Objects.equals(id, girl.id) &&
                Objects.equals(name, girl.name) &&
                Objects.equals(age, girl.age) &&
                Objects.equals(address, girl.address) &&
                Objects.equals(email, girl.email) &&
                Objects.equals(phone, girl.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address, email, phone);
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
