package com.prenevin.springbootlearning.integration.database;

import com.prenevin.springbootlearning.domain.Tool;
import com.prenevin.springbootlearning.repository.api.ToolRepository;
import com.prenevin.springbootlearning.test.integration.DatabaseIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING) // IMO Should not be used but the option is there in JUnit
// Useful for Learning (making sure each test is actually running in isolation)
public class ToolRepositoryIntegrationTest extends DatabaseIntegrationTest {

    @Autowired
    private ToolRepository toolRepository;

    @Test
    public void saveNewTool() {
        Tool tool = new Tool("Anvil");
        toolRepository.save(tool);

        // Should not use the toolRepository to get all the items, as that is the class you are testing
        List<Tool> allTools = getEntityManager().createQuery("Select a from Tool a").getResultList();
        assertThat(allTools)
                .hasSize(1) // Testing that the database is empty. For understanding how the transactions work
                .contains(tool);
    }

    @Test
    @Sql("classpath:integration/sql/toolRepositoryTest.sql")
    public void findByNameThenReturnMatchingTool() {
        Tool tongs = toolRepository.findByName("Tongs");
        assertThat(tongs)
                .isNotNull()
                .hasFieldOrPropertyWithValue("name", "Tongs");
    }
}
