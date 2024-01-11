package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Staff")
@EqualsAndHashCode(callSuper = false)
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staffId;

    @NotEmpty(message = "Name cannot be blank")
    private String firstName;

    @NotEmpty(message = "Name cannot be blank")
    private String lastName;

    private short addressId;
    private String email;
    private boolean active;

    @Column(unique = true)
    private String username;
    private String password;
    private LocalDateTime lastUpdate;
}