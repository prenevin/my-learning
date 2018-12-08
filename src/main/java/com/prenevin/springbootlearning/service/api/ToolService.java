package com.prenevin.springbootlearning.service.api;

import com.prenevin.springbootlearning.domain.Tool;

import java.util.List;

public interface ToolService {

    List<Tool> getTools();

    Tool saveTool(Tool tool);
}
