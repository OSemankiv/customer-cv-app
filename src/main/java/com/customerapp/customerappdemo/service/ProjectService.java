package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.ProjectCreateRequest;
import com.customerapp.customerappdemo.dto.api.ProjectUpdateRequest;
import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.mappers.ProjectMapper;
import com.customerapp.customerappdemo.model.Project;
import com.customerapp.customerappdemo.repository.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProjectService {

    ProjectRepository projectRepository;
    ProjectMapper projectMapper;
    ProjectEntityService projectEntityService;

    @Transactional
    public Project create(ProjectCreateRequest projectCreateRequest) {
        ProjectEntity savedProject = projectEntityService.create(projectCreateRequest);
        return projectMapper.projectEntityToProject(projectRepository.save(savedProject));
    }

    @Transactional(readOnly = true)
    public Project findById(UUID id){
        return projectMapper.projectEntityToProject(projectEntityService.findById(id));
    }

    @Transactional(readOnly = true)
    public List<Project> getAll() {
        return projectRepository.findAllProjects()
                .stream()
                .map(projectMapper::projectEntityToProject)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Project update(UUID projectId, ProjectUpdateRequest project){
            ProjectEntity updateProject = projectEntityService.findById(projectId);
            updateProject.setName(project.getName());
            ProjectEntity savedProject = projectRepository.save(updateProject);
            return projectMapper.projectEntityToProject(savedProject);
    }

    public void delete(UUID id) {
        projectRepository.deleteById(id);
    }
}
