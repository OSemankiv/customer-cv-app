package com.customerapp.customerappdemo.controller;

import com.customerapp.customerappdemo.dto.api.PositionCreateRequest;
import com.customerapp.customerappdemo.model.Position;
import com.customerapp.customerappdemo.service.PositionService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/v1/projects/{projectId}/positions")
public class PositionController {

    PositionService positionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Position create(
            @PathVariable UUID projectId,
            @Valid
            @RequestBody PositionCreateRequest position
    ){
        return positionService.create(projectId, position);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable UUID projectId,
            @PathVariable UUID id
    ){
        positionService.delete(projectId, id);
    }
}
