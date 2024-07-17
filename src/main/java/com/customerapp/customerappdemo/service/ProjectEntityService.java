package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.entity.ProjectEntity;
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

    // naming?
    public ProjectEntity findById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }
}
//  find all projects lazy loading

//jpa to show query from hibernate

// crete 2 projects with 1 position call find all - check queries

//lazy eager - fetch types