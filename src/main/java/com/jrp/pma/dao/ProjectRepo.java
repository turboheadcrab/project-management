package com.jrp.pma.dao;

import com.jrp.pma.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Long> {

}
