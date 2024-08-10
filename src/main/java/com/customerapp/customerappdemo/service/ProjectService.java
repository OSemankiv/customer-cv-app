package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.ProjectCreateRequest;
import com.customerapp.customerappdemo.dto.api.ProjectUpdateRequest;
import com.customerapp.customerappdemo.entity.CandidateEntity;
import com.customerapp.customerappdemo.entity.PositionEntity;
import com.customerapp.customerappdemo.entity.ProjectEntity;
import com.customerapp.customerappdemo.mappers.ProjectMapper;
import com.customerapp.customerappdemo.model.Position;
import com.customerapp.customerappdemo.model.Project;
import com.customerapp.customerappdemo.repository.CandidateRepository;
import com.customerapp.customerappdemo.repository.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProjectService {

    ProjectRepository projectRepository;
    ProjectMapper projectMapper;
    ProjectEntityService projectEntityService;
    private final CandidateRepository candidateRepository;

    public Project create(ProjectCreateRequest projectCreateRequest) {
        ProjectEntity savedProject = projectEntityService.create(projectCreateRequest);
        return projectMapper.projectEntityToProject(savedProject);
    }

    public Project findById(UUID id){
        return projectMapper.projectEntityToProject(projectEntityService.findById(id));
    }

    @Transactional(readOnly = true)
    public List<Project> getAllWithPositionsAndCandidates(){
        List<ProjectEntity> projectEntities = projectRepository.findAllProjects();
        List<UUID> positionIds = projectEntities.stream()
                .flatMap(project -> project.getPositions().stream())
                .map(PositionEntity::getId)
                .toList();
        List<CandidateEntity> candidateEntities = candidateRepository.findAllByPositionIds(positionIds);
        Map<UUID, List<CandidateEntity>> candidatesByPositionId = candidateEntities.stream()
                .collect(Collectors.groupingBy(
                        candidateEntity -> candidateEntity.getPosition().getId()
                ));
        projectEntities.forEach(project -> {
            project.getPositions().forEach(position -> {
                List<CandidateEntity> positionCandidates = candidatesByPositionId.get(position.getId());
                position.setCandidates(positionCandidates != null ? positionCandidates : new ArrayList<>());
            });
        });
    return projectEntities.stream()
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
