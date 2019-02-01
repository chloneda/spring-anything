package com.magic.springboot.model;

import javax.persistence.*;

/**
 * Created by chl
 * Description:
 */
@Entity
@Table(name="mag_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="username",nullable = false)
    private String username;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="sex",nullable = false)
    private String sex;

    public User(){}

    public User(int id,String username,String password,String sex){
        this.id=id;
        this.username=username;
        this.password=password;
        this.sex=sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

}

