package com.customerapp.customerappdemo.dto.api;

import com.customerapp.customerappdemo.model.PositionKey;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCreateRequest {

    @NotNull
    private UUID employeeId;
}
