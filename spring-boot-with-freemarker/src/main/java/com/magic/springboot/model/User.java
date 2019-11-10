package com.magic.springboot.model;

/**
 * @Created by chloneda
 * @Description:
 */
public class User {
    private int id;
    private String name;
    private double money;
    private String password;

    public User() {
    }

    public User(int id, String name, double money, String password) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
