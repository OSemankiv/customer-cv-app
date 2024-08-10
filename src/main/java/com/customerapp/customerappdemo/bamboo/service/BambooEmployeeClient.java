package com.customerapp.customerappdemo.bamboo.service;

import com.customerapp.customerappdemo.bamboo.dto.BambooEmployee;
import com.customerapp.customerappdemo.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bamboo-employee-service", url = "http://localhost:8082/api/v1")
public interface BambooEmployeeClient {

    @GetMapping("/employees")
    List<BambooEmployee> getEmployees();
}
