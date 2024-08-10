package com.customerapp.customerappdemo.mappers;

import com.customerapp.customerappdemo.bamboo.dto.BambooEmployee;
import com.customerapp.customerappdemo.entity.EmployeeEntity;
import com.customerapp.customerappdemo.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    Employee employeeEntityToEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity employeeToEmployeeEntity(Employee employee);

    @Mapping(source = "bambooEmployee.id", target = "bambooId")
    @Mapping(target = "id", ignore = true)
    EmployeeEntity bambooEmployeeToEmployeeEntity(BambooEmployee bambooEmployee);
}
