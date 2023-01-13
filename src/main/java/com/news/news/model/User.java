package com.news.news.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;
    @Min(value = 6, message = "Username is too short!")
    @Max(value = 100, message = "Username is too long!")
    private String username;
    @Min(value = 6, message = "Password is too short!")
    @Max(value = 100, message = "Password is too long!")
    private String password;
}
