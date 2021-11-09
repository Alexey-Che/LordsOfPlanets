package com.example.task.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "planet_table")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planet_id")
    private Long id;
    private String name;
}
