package com.chloneda.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chl on 2019/01/03
 * Description:
 */
public class MagSource {
    private String id;
    private String name;
    private String address;
    private String dataSourceType;
    private int port;
    private String instance;
    private String userName;
    private String password;
    private String connectionUrl;
    private String note;
    private String driverName;
    private transient Set<MagEntity> magEntity = new HashSet<MagEntity>();

    public MagSource(){}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Set<MagEntity> getMagEntity() {
        return magEntity;
    }

    public void setMagEntity(Set<MagEntity> magEntity) {
        this.magEntity = magEntity;
    }

}
