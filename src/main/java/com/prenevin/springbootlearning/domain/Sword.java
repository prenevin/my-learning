package com.prenevin.springbootlearning.domain;

import javax.persistence.*;

@Entity
@Table(name = "sword", uniqueConstraints = @UniqueConstraint(name = "uq_sword_name", columnNames = "name"))
public class Sword {

    @Column(name = "name")
    private String name;

    @OneToOne
    private Knight knight;

}
