package com.prenevin.springbootlearning.repository.impl.spring.data;

import com.prenevin.springbootlearning.domain.Person;
import com.prenevin.springbootlearning.repository.api.PersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person, Long>, PersonRepository {

}
