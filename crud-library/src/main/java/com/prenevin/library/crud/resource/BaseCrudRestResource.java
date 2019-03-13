package com.prenevin.library.crud.resource;


import com.prenevin.library.crud.domain.BaseDomain;
import com.prenevin.library.crud.service.api.BaseCrudService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public abstract class BaseCrudRestResource<T extends BaseDomain> {

    private final BaseCrudService<T> baseCrudService;

    protected BaseCrudRestResource(BaseCrudService<T> baseCrudService) {
        this.baseCrudService = baseCrudService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public T create(@RequestBody T t) {
        return baseCrudService.create(t);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public T update(@RequestBody T t) {
        return baseCrudService.update(t);
    }

    @RequestMapping("/{name}")
    public T findByName(@PathVariable String name) {
        return baseCrudService.findByName(name);
    }

    @RequestMapping
    public List<T> findAll() {
        return baseCrudService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity.BodyBuilder delete(@RequestBody T t) {
        baseCrudService.delete(t);
        return ResponseEntity.ok();
    }
}
