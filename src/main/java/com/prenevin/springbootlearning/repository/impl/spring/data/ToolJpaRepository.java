package com.prenevin.springbootlearning.repository.impl.spring.data;

import com.prenevin.springbootlearning.domain.Tool;
import com.prenevin.springbootlearning.repository.api.ToolRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolJpaRepository extends JpaRepository<Tool, Long>, ToolRepository {

}
