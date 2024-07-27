package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.PositionCreateRequest;
import com.customerapp.customerappdemo.entity.PositionEntity;
import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.model.Project;
import com.customerapp.customerappdemo.repository.PositionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PositionEntityService {

    PositionRepository positionRepository;

    public PositionEntity findById(UUID id) {
        return positionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
    }

    public PositionEntity create(ProjectEntity project, PositionCreateRequest positionCreateRequest) {
        PositionEntity positionEntityToSave = PositionEntity.builder()
                .title(positionCreateRequest.getTitle())
                .requirement(positionCreateRequest.getRequirement())
                .project(project)
                .build();
        return positionRepository.save(positionEntityToSave);
    }
}
