package com.customerapp.customerappdemo.controller;

import com.customerapp.customerappdemo.dto.api.EmployeeCreateRequest;
import com.customerapp.customerappdemo.model.Employee;
import com.customerapp.customerappdemo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/v1/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Valid EmployeeCreateRequest employee) {

        return employeeService.create(employee);
    }

    @GetMapping
    public List<Employee> getAll() {

        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Employee getById(@PathVariable UUID id) {

        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {

        employeeService.delete(id);
        }
}
