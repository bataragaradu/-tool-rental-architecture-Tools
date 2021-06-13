package com.rbinnovative.tools.model.dto;

public class ToolsDTO {
    private Integer id;
    private String name;
    private String imageUrl;
    private boolean available;
    private Integer categoryId;
    private String description;

    public ToolsDTO(){
    }

    public Integer getId() {
        return id;
    }

    public ToolsDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToolsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToolsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public ToolsDTO setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public ToolsDTO setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ToolsDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return "ToolsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
