package com.prenevin.springbootlearning.service.impl;

import com.prenevin.springbootlearning.domain.Tool;
import com.prenevin.springbootlearning.repository.api.ToolRepository;
import com.prenevin.springbootlearning.service.api.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {

    private final ToolRepository toolRepository;

    @Autowired
    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Tool> getTools() {
        return toolRepository.findAll();
    }

    @Override
    @Transactional
    public Tool saveTool(Tool tool) {
        return toolRepository.save(tool);
    }
}
