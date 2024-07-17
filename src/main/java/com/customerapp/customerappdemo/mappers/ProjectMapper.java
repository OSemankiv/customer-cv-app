package com.customerapp.customerappdemo.mappers;

import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.model.Project;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {

    Project projectEntityToProject(ProjectEntity projectEntity);
    ProjectEntity projectToProjectEntity(Project project);
}
