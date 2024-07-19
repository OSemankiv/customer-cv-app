package com.customerapp.customerappdemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity(name = "Project")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;

    @NotBlank
    @NotNull
    String name;

    @OneToMany(mappedBy = "project")
    List<PositionEntity> positions;
}
