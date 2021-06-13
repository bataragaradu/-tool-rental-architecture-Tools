package com.rbinnovative.tools.model.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"tools\"")
public class Tools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "First Name cannot be null")
    private Integer id;
    @Column(name = "[name]")
    private String name;
    @Column(name = "[image_url]")
    private String imageUrl;
    @Column(name = "[available]")
    private boolean available;
    @Column(name = "[category_id]")
    private Integer categoryId;
    @Column(name = "description")
    private String description;
    public Tools() {
    }

    public Integer getId() {
        return id;
    }

    public Tools setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Tools setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Tools setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Tools setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tools setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public Tools setAvailable(boolean available) {
        this.available = available;
        return this;
    }
}
