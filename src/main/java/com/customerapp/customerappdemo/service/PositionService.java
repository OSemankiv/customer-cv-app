package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.PositionCreateRequest;
import com.customerapp.customerappdemo.entity.PositionEntity;
import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.mappers.PositionMapper;
import com.customerapp.customerappdemo.model.Position;
import com.customerapp.customerappdemo.repository.PositionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PositionService {

    PositionRepository positionRepository;
    PositionMapper positionMapper;
    ProjectEntityService projectEntityService;

    @Transactional
    public Position savePosition(UUID projectId, PositionCreateRequest position) {
        ProjectEntity project = projectEntityService.findById(projectId);
        PositionEntity positionEntityToSave = PositionEntity.builder()
                .title(position.getTitle())
                .requirement(position.getRequirement())
                .build();
        positionEntityToSave.setProject(project);
        return positionMapper.positionEntityToPosition(positionRepository.save(positionEntityToSave));
    }

    public void deletePositionById(UUID id) {
        positionRepository.deleteById(id);
    }
}
