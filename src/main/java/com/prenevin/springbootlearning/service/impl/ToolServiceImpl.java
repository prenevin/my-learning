package com.prenevin.springbootlearning.service.impl;

import com.prenevin.springbootlearning.common.BaseCrudServiceImpl;
import com.prenevin.springbootlearning.domain.Tool;
import com.prenevin.springbootlearning.repository.api.ToolRepository;
import com.prenevin.springbootlearning.service.api.ToolService;
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
