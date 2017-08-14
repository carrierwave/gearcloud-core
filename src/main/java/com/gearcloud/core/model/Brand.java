package com.gearcloud.core.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "brand", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Product> products = new HashSet();

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }
}
