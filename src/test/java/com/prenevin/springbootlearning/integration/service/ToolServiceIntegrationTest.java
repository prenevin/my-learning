package com.prenevin.springbootlearning.integration.service;

import com.prenevin.springbootlearning.domain.Tool;
import com.prenevin.springbootlearning.service.api.ToolService;
import com.prenevin.springbootlearning.test.integration.ServiceIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.transaction.TestTransaction;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class ToolServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    private ToolService toolService;

    @Test
    @Sql("classpath:integration/sql/tool.sql")
    public void getAllTools() {
        String[] expectedToolNames = {"Tongs", "Hammer"};
        Tool[] expectedTools = Stream.of(expectedToolNames)
                .map(Tool::new).toArray(Tool[]::new);

        List<Tool> resultTools = toolService.getTools();

        assertThat(resultTools)
                .hasSize(3)
                .contains(expectedTools);
    }

    @Test
    public void saveTool() {
        Tool tool = new Tool("Hammer");

        Tool savedTool = toolService.saveTool(tool);
        List<Tool> resultList = getEntityManager().createQuery("select a from Tool a").getResultList();

        assertThat(resultList)
                .contains(savedTool);
    }

    @Test
    @Sql("classpath:integration/sql/tool.sql")
    public void saveToolThatAlreadyExists() {
        Tool tool = new Tool("Hammer");

        try {
            toolService.saveTool(tool);
            fail("Can't save a tool that already exists");
        } catch (DataIntegrityViolationException expected) {
            assertThat(TestTransaction.isFlaggedForRollback())
                    .isTrue();

        }
    }
}
