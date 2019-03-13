package com.prenevin.springbootlearning.service.impl;

import com.prenevin.springbootlearning.common.BaseCrudServiceImpl;
import com.prenevin.springbootlearning.domain.Person;
import com.prenevin.springbootlearning.repository.api.PersonRepository;
import com.prenevin.springbootlearning.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl extends BaseCrudServiceImpl<Person> implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        super(personRepository);

        this.personRepository = personRepository;
    }
}
