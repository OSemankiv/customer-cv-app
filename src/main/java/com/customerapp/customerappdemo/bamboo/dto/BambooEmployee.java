package com.customerapp.customerappdemo.bamboo.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BambooEmployee {

    Long id;
    String firstName;
    String lastName;
    String displayName;
    String location;
    String department;
    String jobTitle;
    String workEmail;
}
