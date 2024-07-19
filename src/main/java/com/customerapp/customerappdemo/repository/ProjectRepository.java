package com.customerapp.customerappdemo.repository;

import com.customerapp.customerappdemo.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {

    //TODO:write jpql for get all projects
}

