package com.gearcloud.core.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String bio;

    @OneToMany(targetEntity = Possession.class, mappedBy = "profile", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Possession> possessions = new HashSet();

    public Profile(String fullName, String bio) {
        this.fullName = fullName;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Possession> getPossessions() {
        return possessions;
    }

    public void setPossessions(Set<Possession> possessions) {
        this.possessions = possessions;
    }

}
