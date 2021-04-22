package com.rbinnovative.tools.model.dto;

public class CategoryDTO {
    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public CategoryDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
