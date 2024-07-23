package com.customerapp.customerappdemo.controller;

import com.customerapp.customerappdemo.dto.api.ProjectCreateRequest;
import com.customerapp.customerappdemo.model.Project;
import com.customerapp.customerappdemo.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody @Valid ProjectCreateRequest project) {
        return projectService.save(project.getName());
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable UUID id) {
        return projectService.findById(id);
    }

    @GetMapping
    public List<Project> getAll(){
        return projectService.getAll();
    }
}
