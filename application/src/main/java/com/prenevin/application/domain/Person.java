package com.prenevin.application.domain;

import com.prenevin.library.crud.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person", uniqueConstraints = @UniqueConstraint(name = "uq_person_name", columnNames = "name"))
public class Person extends BaseDomain {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

}
