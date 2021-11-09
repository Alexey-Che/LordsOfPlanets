package com.example.task.repository;

import com.example.task.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    void deleteByName(String name);
    @Query("select p from Planet p where p.name = ?1")
    Planet getByName(String name);
}
