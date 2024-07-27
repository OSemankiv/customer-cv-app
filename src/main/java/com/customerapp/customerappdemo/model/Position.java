package com.customerapp.customerappdemo.model;

import com.customerapp.customerappdemo.entity.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Position {

    UUID id;
    String title;
    String requirement;
    Status status;
}
