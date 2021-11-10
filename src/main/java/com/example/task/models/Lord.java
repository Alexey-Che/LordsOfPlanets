package com.example.task.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "lord")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private int age;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "lord_id")
    @ToString.Exclude
    private List<Planet> planets = new ArrayList<>();

    public Lord(Long id, String name, int age, List<Planet> planets) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.planets = planets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Lord lord = (Lord) o;
        return id != null && Objects.equals(id, lord.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
