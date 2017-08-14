package com.gearcloud.core.model;

import javax.persistence.*;

@Entity
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "possession_id")
    private Possession possession;

    public Statement() {
    }

    public Statement(String text) {
        this.text = text;
    }

    public Statement(String text, Possession possession) {
        this.text = text;
        this.possession = possession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Possession getPossession() {
        return possession;
    }

    public void setPossession(Possession possession) {
        this.possession = possession;
    }
}
