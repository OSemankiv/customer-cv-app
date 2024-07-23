package com.customerapp.customerappdemo.repository;

import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {

    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.positions")
    List<ProjectEntity> findAllProjects();
    //TODO:write jpql for get all projects
}

