package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.entity.EmployeeEntity;
import com.customerapp.customerappdemo.exception.DataNotFoundException;
import com.customerapp.customerappdemo.mappers.EmployeeMapper;
import com.customerapp.customerappdemo.model.Employee;
import com.customerapp.customerappdemo.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeEntityService {

    EmployeeMapper  employeeMapper;
    EmployeeRepository employeeRepository;

    //not needed?
    public EmployeeEntity save(Employee employee) {
        return employeeMapper.employeeToEmployeeEntity(employee);
    }

    public EmployeeEntity findById(UUID id) {
        return employeeRepository
                .findById(id).orElseThrow(() -> new DataNotFoundException("Employee %s not found".formatted(id)));
    }
}
