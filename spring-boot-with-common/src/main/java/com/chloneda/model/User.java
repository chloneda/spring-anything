package com.chloneda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author chloneda
 * @description:
 */
@Entity
@Table(name = "USER")
public class User extends Person {

    private static final long serialVersionUID = 1L;

    @Column(name = "ADDRESS", length = 128)
    private String address;

    @Column(name = "EMAIL", length = 128)
    private String email;

    @Column(name = "PHONE", length = 64)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(address, user.address) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, email, phone);
    }

}
