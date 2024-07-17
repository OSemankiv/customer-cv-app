package com.customerapp.customerappdemo.dto.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateRequest {

    @NotBlank
    @NotNull
    String firstName;

    @NotBlank
    @NotNull
    String lastName;

    @NotBlank
    @NotNull
    String displayName;

    @NotBlank
    @NotNull
    String location;

    @NotBlank
    @NotNull
    String department;

    @NotBlank
    @NotNull
    String jobTitle;

    @NotBlank
    @NotNull
    String workEmail;
}
