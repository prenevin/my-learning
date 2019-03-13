package com.prenevin.application.repository.impl.spring.data;

import com.prenevin.application.domain.Person;
import com.prenevin.application.repository.api.PersonRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person, Long>, PersonRepository {

}
