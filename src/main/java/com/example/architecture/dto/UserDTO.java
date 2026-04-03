package com.example.architecture.dto;

import jakarta.persistence.Column;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    int id;

    @Column(unique = true)
    String name;
}
