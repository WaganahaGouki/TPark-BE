package com.example.tparkbe.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Login {
    private final String email;
    private final String password;
}
