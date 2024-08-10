package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.CandidateCreateRequest;
import com.customerapp.customerappdemo.entity.CandidateEntity;
import com.customerapp.customerappdemo.repository.CandidateRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CandidateEntityService {

}
