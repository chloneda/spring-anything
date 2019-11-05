package com.magic.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chloneda
 * @description:
 */
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtoUser {

    @ApiModelProperty(
            value = "实体Id",
            example = "asdfghjkl"
    )
    private String id;

    @ApiModelProperty(
            value = "用户名称",
            example = "lili"
    )
    private String username;

    @ApiModelProperty(
            value = "用户年龄",
            example = "18"
    )
    private String age;

    @ApiModelProperty(
            value = "用户性别",
            example = "woman"
    )
    private String sex;

    @ApiModelProperty(
            value = "用户地址",
            example = "BeiJing"
    )
    private String address;

    @ApiModelProperty(
            value = "用户邮箱",
            example = "lili@163.com"
    )
    private String email;

    @ApiModelProperty(
            value = "用户电话",
            example = "123482094056"
    )
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

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

}
