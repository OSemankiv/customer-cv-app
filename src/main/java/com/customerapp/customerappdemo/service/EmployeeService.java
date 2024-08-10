package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.dto.api.EmployeeCreateRequest;
import com.customerapp.customerappdemo.entity.EmployeeEntity;
import com.customerapp.customerappdemo.mappers.EmployeeMapper;
import com.customerapp.customerappdemo.model.Employee;

import com.customerapp.customerappdemo.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeService {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    EmployeeEntityService employeeEntityService;

    @Transactional(readOnly = true)
    public List<Employee> findAll(){
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::employeeEntityToEmployee)
                .collect(Collectors.toList());
    }

    @Transactional
    public Employee create(EmployeeCreateRequest employeeCreateRequest){
        EmployeeEntity savedEmployee = employeeEntityService.create(employeeCreateRequest);
        return employeeMapper.employeeEntityToEmployee(savedEmployee);
    }

    @Transactional(readOnly = true)
    public Employee findById(UUID id){
       return employeeMapper.employeeEntityToEmployee(employeeEntityService.findById(id));
    }

    public void delete(UUID id) {
            employeeRepository.deleteById(id);
    }
}
