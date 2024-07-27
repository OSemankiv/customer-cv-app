package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.ProjectCreateRequest;
import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.exception.DataNotFoundException;
import com.customerapp.customerappdemo.repository.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProjectEntityService {

    ProjectRepository projectRepository;

    public ProjectEntity findById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Project with id %s not found".formatted(id)));
    }


    public ProjectEntity create(ProjectCreateRequest projectCreateRequest) {
        ProjectEntity projectEntityToSave = ProjectEntity.builder()
                .name(projectCreateRequest.getName())
                .build();
        return projectRepository.save(projectEntityToSave);
    }
}