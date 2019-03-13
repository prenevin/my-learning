package com.prenevin.springbootlearning.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Knight extends Person {

    @Column(name = "kingdom")
    private String kingdom;

    @OneToOne(cascade = CascadeType.ALL)
    private Sword sword;

}
