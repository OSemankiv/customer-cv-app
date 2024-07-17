package com.customerapp.customerappdemo.mappers;

import com.customerapp.customerappdemo.entity.EmployeeEntity;
import com.customerapp.customerappdemo.model.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee employeeEntityToEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity employeeToEmployeeEntity(Employee employee);
}
