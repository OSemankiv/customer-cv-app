package com.customerapp.customerappdemo.controller;

import com.customerapp.customerappdemo.dto.api.CandidateCreateRequest;
import com.customerapp.customerappdemo.model.Candidate;
import com.customerapp.customerappdemo.model.PositionKey;
import com.customerapp.customerappdemo.service.CandidateService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/v1/projects/{projectId}/positions/{positionId}/candidates")
public class CandidateController {

    CandidateService candidateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Candidate create(@PathVariable UUID projectId,
                            @PathVariable UUID positionId,
                            @RequestBody @Valid CandidateCreateRequest createRequest){
        PositionKey positionKey = new PositionKey(projectId, positionId);
        return candidateService.addCandidateToPosition(positionKey, createRequest.getEmployeeId());
    }
}
