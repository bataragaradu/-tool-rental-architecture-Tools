package com.rbinnovative.tools.model.dto;

public class ToolsDTO {
    private Integer id;
    private String name;
    private String imageUrl;
    private boolean available;

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
