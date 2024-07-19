package com.customerapp.customerappdemo.dto.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAndPositionCreateRequest {

    @Valid
    PositionCreateRequest position;

    @Valid
    ProjectCreateRequest project;
}
