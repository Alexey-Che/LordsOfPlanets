package com.example.task.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planet_id")
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "lord_id")
    private Lord lord;

    public Planet(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Planet(Long id, String name, Lord lord) {
        this.id = id;
        this.name = name;
        this.lord = lord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Planet planet = (Planet) o;
        return id != null && Objects.equals(id, planet.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
