package com.example.interviewitprom.repositories;

import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<DepartmentEntity, Long> {
}
