package com.customerapp.customerappdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity(name = "Employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @NotNull
    @NotBlank
    String firstName;

    @NotNull
    @NotBlank
    String lastName;

    @NotNull
    @NotBlank
    String displayName;

    @NotNull
    @NotBlank
    String location;

    @NotNull
    @NotBlank
    String department;

    @NotNull
    @NotBlank
    String jobTitle;

    @NotNull
    @NotBlank
    String workEmail;

    Long bambooId;
}
