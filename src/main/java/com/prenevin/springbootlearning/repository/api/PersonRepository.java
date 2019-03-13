package com.prenevin.springbootlearning.repository.api;

import com.prenevin.springbootlearning.common.BaseRepository;
import com.prenevin.springbootlearning.domain.Person;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository extends BaseRepository<Person> {

}
