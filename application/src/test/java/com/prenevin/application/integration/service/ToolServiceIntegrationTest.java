package com.prenevin.application.integration.service;

import com.prenevin.application.domain.Tool;
import com.prenevin.application.service.api.ToolService;
import com.prenevin.test.integration.ServiceIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.transaction.TestTransaction;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class ToolServiceIntegrationTest extends ServiceIntegrationTest {

    @Autowired
    private ToolService toolService;

    @Test
    @Sql("classpath:com/prenevin/test/integration/sql/tool.sql")
    public void getAllTools() {
        String[] expectedToolNames = {"Tongs", "Hammer"};
        Tool[] expectedTools = Stream.of(expectedToolNames)
            .map(Tool::new).toArray(Tool[]::new);

        List<Tool> resultTools = toolService.findAll();

        assertThat(resultTools)
            .hasSize(3)
            .contains(expectedTools);
    }

    @Test
    public void saveTool() {
        Tool tool = new Tool("Hammer");

        Tool savedTool = toolService.create(tool);
        List<Tool> resultList = getEntityManager().createQuery("select a from Tool a").getResultList();

        assertThat(resultList)
            .contains(savedTool);
    }

    @Test
    @Sql("classpath:com/prenevin/test/integration/sql/tool.sql")
    public void saveToolThatAlreadyExists() {
        Tool tool = new Tool("Hammer");

        try {
            toolService.update(tool);
            fail("Can't save a tool that already exists");
        } catch (DataIntegrityViolationException expected) {
            assertThat(TestTransaction.isFlaggedForRollback())
                .isTrue();

        }
    }
}
