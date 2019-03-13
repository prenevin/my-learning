package com.prenevin.springbootlearning.common;

import java.util.List;

public interface BaseCrudService<T extends BaseDomain> {
    T create(T t);

    T update(T t);

    T findByName(String name);

    List<T> findAll();

    void delete(T t);
}
