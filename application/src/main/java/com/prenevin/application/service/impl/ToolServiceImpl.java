package com.prenevin.application.service.impl;

import com.prenevin.application.domain.Tool;
import com.prenevin.application.repository.api.ToolRepository;
import com.prenevin.application.service.api.ToolService;
import com.prenevin.library.crud.service.impl.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ToolServiceImpl extends BaseCrudServiceImpl<Tool> implements ToolService {

    private final ToolRepository toolRepository;

    public ToolServiceImpl(ToolRepository toolRepository) {
        super(toolRepository);
        this.toolRepository = toolRepository;
    }
}
