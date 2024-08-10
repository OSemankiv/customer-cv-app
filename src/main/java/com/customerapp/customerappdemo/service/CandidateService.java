package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.entity.CandidateEntity;
import com.customerapp.customerappdemo.entity.EmployeeEntity;
import com.customerapp.customerappdemo.entity.PositionEntity;
import com.customerapp.customerappdemo.mappers.CandidateMapper;
import com.customerapp.customerappdemo.model.Candidate;
import com.customerapp.customerappdemo.model.PositionKey;
import com.customerapp.customerappdemo.repository.CandidateRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CandidateService {

    PositionEntityService positionEntityService;
    EmployeeEntityService employeeEntityService;
    CandidateRepository candidateRepository;
    CandidateMapper candidateMapper;

    @Transactional
    public Candidate addCandidateToPosition(PositionKey positionKey, UUID employeeId){
        PositionEntity position = positionEntityService.findByIdAndProjectId(positionKey.positionId(), positionKey.projectId());
        EmployeeEntity employee = employeeEntityService.findById(employeeId);
        CandidateEntity candidateEntityToSave = CandidateEntity.builder()
                .employee(employee)
                .position(position)
                .build();
        CandidateEntity savedCandidate = candidateRepository.save(candidateEntityToSave);
        return candidateMapper.candidateEntityToCandidate(savedCandidate);
    }
}
