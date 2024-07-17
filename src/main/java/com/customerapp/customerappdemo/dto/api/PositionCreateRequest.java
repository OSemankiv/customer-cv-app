package com.customerapp.customerappdemo.dto.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionCreateRequest {

    @NotBlank
    @NotNull
    String title;

    @NotBlank
    @NotNull
    String requirement;
}
