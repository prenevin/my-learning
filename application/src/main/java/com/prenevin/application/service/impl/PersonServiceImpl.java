package com.prenevin.application.service.impl;

import com.prenevin.application.domain.Person;
import com.prenevin.application.repository.api.PersonRepository;
import com.prenevin.application.service.api.PersonService;
import com.prenevin.library.crud.service.impl.BaseCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl extends BaseCrudServiceImpl<Person> implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        super(personRepository);

        this.personRepository = personRepository;
    }
}
