package com.prenevin.springbootlearning.common;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomain {

    @Id
    @GeneratedValue
    private Long id;
    // Does Id need a getter and setter or can JPA set this without them?
    // Non of the code I right should access or modify this fields
}
