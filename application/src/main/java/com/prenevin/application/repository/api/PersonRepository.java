package com.prenevin.application.repository.api;

import com.prenevin.library.crud.repository.BaseRepository;
import com.prenevin.application.domain.Person;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository extends BaseRepository<Person> {

}
