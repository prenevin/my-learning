package com.prenevin.application.repository.impl.spring.data;

import com.prenevin.application.domain.Tool;
import com.prenevin.application.repository.api.ToolRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolJpaRepository extends JpaRepository<Tool, Long>, ToolRepository {

}
