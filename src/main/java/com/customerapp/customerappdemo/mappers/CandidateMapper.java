package com.customerapp.customerappdemo.mappers;

import com.customerapp.customerappdemo.entity.CandidateEntity;
import com.customerapp.customerappdemo.model.Candidate;
import com.customerapp.customerappdemo.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CandidateMapper {

    EmployeeMapper employeeMapper;

    public Candidate candidateEntityToCandidate(CandidateEntity candidateEntity){
        return Candidate.builder()
                .id(candidateEntity.getId())
                .positionId(candidateEntity.getPosition().getId())
                .employee(employeeMapper.employeeEntityToEmployee(candidateEntity.getEmployee()))
                .build();
    }
}
