package com.chloneda.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Life implements Lifeable {

    @Column(name = "LAST_MODIFIED_TIME", nullable = false, length = 11)
    private Date lastModifiedTime;

    @Column(name = "CREATED_TIME", nullable = false, length = 11)
    private Date createdTime;

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
