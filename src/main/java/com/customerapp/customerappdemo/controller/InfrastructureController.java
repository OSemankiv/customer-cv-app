package com.customerapp.customerappdemo.controller;

import com.customerapp.customerappdemo.service.EmployeeSyncService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("v1/bamboo")
public class InfrastructureController {

    EmployeeSyncService employeeSyncService;

    @PostMapping("/sync-employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void syncEmployees() {
        employeeSyncService.syncEmployees();
    }
}
