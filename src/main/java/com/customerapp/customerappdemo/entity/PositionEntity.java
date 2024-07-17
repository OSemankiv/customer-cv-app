package com.customerapp.customerappdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @NotBlank
    @NotNull
    String title;

    @NotBlank
    @NotNull
    String requirement;

    @NotBlank
    @NotNull
    @ManyToOne
    ProjectEntity project;
}
