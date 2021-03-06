package com.prenevin.library.crud.repository;


import com.prenevin.library.crud.domain.BaseDomain;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public interface BaseRepository<T extends BaseDomain> {
    T save(T t);

    T findByName(String name);

    List<T> findAll();

    void delete(T t);
}
