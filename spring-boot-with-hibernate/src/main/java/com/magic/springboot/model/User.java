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
    @Column(name="money",nullable = false)
    private double money;

    public User(){}

    public User(int id,String username,String password,double money){
        this.id=id;
        this.username=username;
        this.password=password;
        this.money=money;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

}

