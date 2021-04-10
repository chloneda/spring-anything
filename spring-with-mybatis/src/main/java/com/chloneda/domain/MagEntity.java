package com.chloneda.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chl on 2019/01/03
 * Description:
 */
public class MagEntity {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String alias;
    private String keywords;
    private String uri;
    private String note;
    private String entityName;
    private Set<MagColumn> columns = new HashSet<MagColumn>();
    private MagSource magSource;

    public MagEntity(){}

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Set<MagColumn> getColumns() {
        return columns;
    }

    public void setColumns(Set<MagColumn> columns) {
        this.columns = columns;
    }

    public MagSource getMagSource() {
        return magSource;
    }

    public void setMagSource(MagSource magSource) {
        this.magSource = magSource;
    }

}
