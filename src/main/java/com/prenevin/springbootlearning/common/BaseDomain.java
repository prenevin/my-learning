package com.prenevin.springbootlearning.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Does Id need a getter and setter or can JPA set this without them?
    // Seems to be working
    //Con - Spring data Jpa needs it to find one.
    //Pro - Forces the usage of the logical key

    // Non of the code I right should access or modify this fields
}
