package com.customerapp.customerappdemo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    UUID id;
    String firstName;
    String lastName;
    String displayName;
    String location;
    String department;
    String jobTitle;
    String workEmail;
}
