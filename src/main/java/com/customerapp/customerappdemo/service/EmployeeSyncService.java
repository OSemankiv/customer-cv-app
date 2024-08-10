package com.customerapp.customerappdemo.service;

import com.customerapp.customerappdemo.bamboo.dto.BambooEmployee;
import com.customerapp.customerappdemo.bamboo.service.BambooEmployeeClient;
import com.customerapp.customerappdemo.entity.EmployeeEntity;
import com.customerapp.customerappdemo.mappers.EmployeeMapper;
import com.customerapp.customerappdemo.model.Employee;
import com.customerapp.customerappdemo.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeSyncService {

    BambooEmployeeClient bambooEmployeeClient;
    EmployeeRepository  employeeRepository;
    EmployeeMapper employeeMapper;

    public void syncEmployees() {
        List<BambooEmployee> bambooEmployees = bambooEmployeeClient.getEmployees();
        List<EmployeeEntity> entitiesToSave = new ArrayList<>();
        bambooEmployees.forEach(employee -> {
            Optional<EmployeeEntity> externalEmployee = employeeRepository.findByBambooId(employee.getId());
            if(externalEmployee.isEmpty()) {
                EmployeeEntity newEmployee = employeeMapper.bambooEmployeeToEmployeeEntity(employee);
                entitiesToSave.add(newEmployee);
            } else {
                EmployeeEntity existingEmployee = getEmployee(employee, externalEmployee);
                entitiesToSave.add(existingEmployee);
            }
            employeeRepository.saveAll(entitiesToSave);
        });
    }

    private static EmployeeEntity getEmployee(BambooEmployee employee, Optional<EmployeeEntity> externalEmployee) {
        EmployeeEntity existingEmployee = externalEmployee.get();
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setDisplayName(employee.getDisplayName());
        existingEmployee.setLocation(employee.getLocation());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setJobTitle(employee.getJobTitle());
        existingEmployee.setWorkEmail(employee.getWorkEmail());
        existingEmployee.setBambooId(employee.getId());
        return existingEmployee;
    }
}
