package com.chloneda.persistence;

import java.util.Date;

public interface Lifeable {

  Date getCreatedTime();

  void setCreatedTime(Date createdTime);

  Date getLastModifiedTime();

  void setLastModifiedTime(Date lastModifiedTime);

}
