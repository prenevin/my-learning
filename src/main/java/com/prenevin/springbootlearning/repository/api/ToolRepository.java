package com.prenevin.springbootlearning.repository.api;

import com.prenevin.springbootlearning.common.BaseRepository;
import com.prenevin.springbootlearning.domain.Tool;
import org.springframework.data.repository.NoRepositoryBean;

// Exposing this allows me to restrict the methods that come with Springs JPA and Crud repositories
// Keeping a cleaner abstraction to what the repository should do
@NoRepositoryBean
public interface ToolRepository extends BaseRepository<Tool> {

}
