package com.rbinnovative.tools.model;

public class ToolRequest {
    private Integer id;
    private String name;

    public ToolRequest(){
//
    }
    public Integer getId() {
        return id;
    }

    public ToolRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToolRequest setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "ToolRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
