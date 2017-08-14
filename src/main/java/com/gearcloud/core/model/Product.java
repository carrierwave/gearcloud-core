package com.gearcloud.core.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    private String name;
    @ManyToOne
    @JoinColumn(name= "community_id")
    private Community community;

    @OneToMany(targetEntity = Possession.class, mappedBy = "product", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Possession> possessors = new HashSet();

    public Product(Brand brand, String name, Community community) {
        this.brand = brand;
        this.name = name;
        this.community = community;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
