package com.prenevin.springbootlearning.resource;


import com.prenevin.springbootlearning.common.BaseCrudRestResource;
import com.prenevin.springbootlearning.domain.Tool;
import com.prenevin.springbootlearning.service.api.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools") //Rest suggests that Objects go in a directory structure
public class ToolResource extends BaseCrudRestResource<Tool> {

    private final ToolService toolService;

    @Autowired
    public ToolResource(ToolService toolService) {
        super(toolService);
        this.toolService = toolService;
    }
}
