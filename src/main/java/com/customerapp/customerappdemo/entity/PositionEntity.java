package com.customerapp.customerappdemo.entity;

import jakarta.persistence.*;
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
@Entity(name = "Position")
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

    @NotNull
    @ManyToOne
    ProjectEntity project;
}
