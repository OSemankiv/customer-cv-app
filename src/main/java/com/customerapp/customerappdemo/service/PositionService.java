package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.PositionCreateRequest;
import com.customerapp.customerappdemo.dto.api.ProjectAndPositionCreateRequest;
import com.customerapp.customerappdemo.entity.PositionEntity;
import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.exception.DataNotFoundException;
import com.customerapp.customerappdemo.mappers.PositionMapper;
import com.customerapp.customerappdemo.mappers.ProjectMapper;
import com.customerapp.customerappdemo.model.Position;
import com.customerapp.customerappdemo.model.Project;
import com.customerapp.customerappdemo.repository.PositionRepository;
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
public class PositionService {

    PositionRepository positionRepository;
    PositionMapper positionMapper;
    ProjectEntityService projectEntityService;
    PositionEntityService positionEntityService;
    ProjectMapper projectMapper;

    @Transactional
    public Position create(UUID projectId, PositionCreateRequest position) {
        ProjectEntity project = projectEntityService.findById(projectId);
        PositionEntity createdPosition = positionEntityService.create(project, position);
        return mapToDomain(createdPosition);
    }

    @Transactional
    public Project createWithProject(ProjectAndPositionCreateRequest positionAndProj) {
        ProjectEntity projectEntity = projectEntityService.create(positionAndProj.getProject());
        positionEntityService.create(projectEntity, positionAndProj.getPosition());
        return projectMapper.projectEntityToProject(projectEntity);
    }

    public void delete(UUID id, UUID projectId) {
        positionRepository.deleteByIdAndProjectId(id, projectId);
    }

    private Position mapToDomain(PositionEntity createdPosition) {
        return positionMapper.positionEntityToPosition(createdPosition);
    }
}
