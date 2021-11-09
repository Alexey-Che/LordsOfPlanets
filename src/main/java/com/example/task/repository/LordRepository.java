package com.example.task.repository;

import com.example.task.models.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LordRepository extends JpaRepository<Lord, Long> {

    @Query("select l from Lord l where l.name = ?1")
    Lord getByName(String name);
}
