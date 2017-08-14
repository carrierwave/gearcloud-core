package com.gearcloud.core.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name="ID")
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    @OneToMany(targetEntity = Product.class, mappedBy = "community", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Product> products = new HashSet();
    @ManyToMany
    @JoinTable(name = "COMMUNITY_PROFILE",
    joinColumns = @JoinColumn(name="COMMUNITY_ID", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name="PROFILE_ID", referencedColumnName = "ID"))
    private Set<Profile> profiles = new HashSet();

    public Community() {
    }

    public Community(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
