package com.prenevin.springbootlearning.repository.api;

import com.prenevin.springbootlearning.domain.Tool;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ToolRepository {

    Tool findByName(String name);

    Tool save(Tool tool);

    List<Tool> findAll();
}
