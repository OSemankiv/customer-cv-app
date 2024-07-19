package com.customerapp.customerappdemo.controller;

import com.customerapp.customerappdemo.dto.api.EmployeeCreateRequest;
import com.customerapp.customerappdemo.model.Employee;
import com.customerapp.customerappdemo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Valid EmployeeCreateRequest employee) {

        return employeeService.save(employee);
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
