package com.example.REST_demo.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

}
