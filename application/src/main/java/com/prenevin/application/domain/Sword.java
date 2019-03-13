package com.prenevin.application.domain;

import com.prenevin.library.crud.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sword", uniqueConstraints = @UniqueConstraint(name = "uq_sword_name", columnNames = "name"))
public class Sword extends BaseDomain {

    @Column(name = "name")
    private String name;

    @OneToOne
    private Knight knight;

}
