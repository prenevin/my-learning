package com.prenevin.application.integration.database;

import com.prenevin.application.domain.Tool;
import com.prenevin.application.repository.api.ToolRepository;
import com.prenevin.test.integration.DatabaseIntegrationTest;
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
    @Sql("classpath:com/prenevin/test/integration/sql/tool.sql")
    public void findByNameThenReturnMatchingTool() {
        Tool tongs = toolRepository.findByName("Tongs");
        assertThat(tongs)
            .isNotNull()
            .hasFieldOrPropertyWithValue("name", "Tongs");
    }


    // TODO How to test an update
    // This test is not doing that as the update did not commit
    @Test
    @Sql("classpath:com/prenevin/test/integration/sql/tool.sql")
    public void updateExistingTool() {
        Tool tongs = (Tool) getEntityManager().createQuery("select a from Tool a where a.name='Tongs'").getSingleResult();
        tongs.setName("Metal Tongs");

        List<Tool> resultList = getEntityManager().createQuery("select a from Tool a").getResultList();
        assertThat(resultList)
            .isNotNull()
            .contains(tongs)
            .doesNotContain(new Tool("Tongs"));
    }

    @Test
    @Sql("classpath:com/prenevin/test/integration/sql/tool.sql")
    public void deleteExistingTool() {
        Tool tongs = (Tool) getEntityManager().createQuery("select a from Tool a where a.name='Tongs'").getSingleResult();
        toolRepository.delete(tongs);

        List<Tool> resultList = getEntityManager().createQuery("select a from Tool a").getResultList();
        assertThat(resultList)
            .isNotNull()
            .doesNotContain(tongs);
    }
}
