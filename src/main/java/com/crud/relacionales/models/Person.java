package com.crud.relacionales.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="document")
    private String document;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;
}
