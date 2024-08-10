package com.customerapp.customerappdemo.model;

import com.customerapp.customerappdemo.entity.EmployeeEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Candidate {

    UUID id;
    Employee employee;
    UUID positionId;
}
