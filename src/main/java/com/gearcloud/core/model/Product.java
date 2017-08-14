package com.gearcloud.core.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String name;
    private String gearCommunity;

    @OneToMany(targetEntity = Possession.class, mappedBy = "product", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Possession> possessors = new HashSet();

    public Product(String brand, String name, String gearCommunity) {
        this.brand = brand;
        this.name = name;
        this.gearCommunity = gearCommunity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGearCommunity() {
        return gearCommunity;
    }

    public void setGearCommunity(String gearCommunity) {
        this.gearCommunity = gearCommunity;
    }
}
