package com.prenevin.springbootlearning.domain;

import com.prenevin.springbootlearning.common.BaseDomain;

import javax.persistence.*;

@Entity
@Table(name = "sword", uniqueConstraints = @UniqueConstraint(name = "uq_sword_name", columnNames = "name"))
public class Sword extends BaseDomain {

    @Column(name = "name")
    private String name;

    @OneToOne
    private Knight knight;

}
