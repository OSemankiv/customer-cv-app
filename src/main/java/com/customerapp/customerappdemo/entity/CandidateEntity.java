package com.customerapp.customerappdemo.entity;

import com.customerapp.customerappdemo.model.Employee;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Candidate")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID Id;

    @ManyToOne
    EmployeeEntity employee;

    @ManyToOne
    PositionEntity position;
}
