package com.customerapp.customerappdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
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

    @Enumerated(EnumType.STRING)
    @Builder.Default
    Status status = Status.ACTIVE;

    @OneToMany(
            mappedBy = "position",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<CandidateEntity> candidates = new ArrayList<>();
}
