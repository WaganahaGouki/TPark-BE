package com.example.tparkbe.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Register {
    private final String username;
    private final String email;
    private final String password;
}
