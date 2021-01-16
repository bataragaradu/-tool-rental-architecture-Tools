package com.rbinnovative.tools.model;

public class ToolsDTO {
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "ToolsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
