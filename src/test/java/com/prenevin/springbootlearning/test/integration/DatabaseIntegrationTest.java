package com.prenevin.springbootlearning.test.integration;

import lombok.AccessLevel;
import lombok.Getter;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // Causes the transaction to rollback after each test, keeping each test case clean
public class DatabaseIntegrationTest {

    @Autowired
    @Getter(value = AccessLevel.PROTECTED)
    private EntityManager entityManager;

}
