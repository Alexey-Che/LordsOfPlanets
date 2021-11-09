package com.example.task.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "lord_table")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private int age;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "lord_id")
    private List<Planet> planets = new ArrayList<>();
}
