package com.nur.dtos;

import com.nur.annotations.Generated;

@Generated
public class CommendDTO {
    public String id;
    public String userId;
    public String valoration;
    public String description;
    public String property;
    public Integer points;

    public CommendDTO() {
    }

    public CommendDTO(String id, String userId, String valoration, String description, String property, Integer points) {
        this.id = id;
        this.userId = userId;
        this.valoration = valoration;
        this.description = description;
        this.property = property;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getValoration() {
        return valoration;
    }

    public void setValoration(String valoration) {
        this.valoration = valoration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
