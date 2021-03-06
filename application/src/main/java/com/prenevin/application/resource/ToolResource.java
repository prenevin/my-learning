package com.prenevin.application.resource;


import com.prenevin.library.crud.resource.BaseCrudRestResource;
import com.prenevin.application.domain.Tool;
import com.prenevin.application.service.api.ToolService;
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
