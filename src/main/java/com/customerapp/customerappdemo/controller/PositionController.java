package com.customerapp.customerappdemo.controller;

import com.customerapp.customerappdemo.dto.api.PositionCreateRequest;
import com.customerapp.customerappdemo.model.Position;
import com.customerapp.customerappdemo.service.PositionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/projects/{id}/positions")
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Position create(@PathVariable UUID id,
                           @Valid
                                   @RequestBody PositionCreateRequest position){
        return positionService.save(id, position);
    }
}
