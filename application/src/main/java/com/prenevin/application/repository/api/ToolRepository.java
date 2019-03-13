package com.prenevin.application.repository.api;

import com.prenevin.library.crud.repository.BaseRepository;
import com.prenevin.application.domain.Tool;
import org.springframework.data.repository.NoRepositoryBean;

// Exposing this allows me to restrict the methods that come with Springs JPA and Crud repositories
// Keeping a cleaner abstraction to what the repository should do
@NoRepositoryBean
public interface ToolRepository extends BaseRepository<Tool> {

}
