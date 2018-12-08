package com.prenevin.springbootlearning.domain;


import com.prenevin.springbootlearning.common.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tool")
public class Tool extends BaseDomain {

    @Column(name = "name")
    private String name;

}
