package com.gearcloud.core.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Possession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Enumerated(EnumType.STRING)
    private Affinity affinity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(targetEntity = Statement.class, mappedBy = "possession", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Statement> statements = new HashSet();


    public Possession(Profile profile, Affinity affinity, Product product) {
        this.profile = profile;
        this.affinity = affinity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Affinity getAffinity() {
        return affinity;
    }

    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    public Set<Statement> getStatements() {
        return statements;
    }

    public void setStatements(Set<Statement> statements) {
        this.statements = statements;
    }
}
