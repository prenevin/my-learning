package com.prenevin.library.crud.service.impl;

import com.prenevin.library.crud.domain.BaseDomain;
import com.prenevin.library.crud.repository.BaseRepository;
import com.prenevin.library.crud.service.api.BaseCrudService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class BaseCrudServiceImpl<T extends BaseDomain> implements BaseCrudService<T> {

    private final BaseRepository<T> repository;

    protected BaseCrudServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T t) {
        return repository.save(t);
    }

    @Override
    public T update(T t) {
        return repository.save(t);
    }

    @Override
    @Transactional(readOnly = true)
    public T findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }


}
