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
