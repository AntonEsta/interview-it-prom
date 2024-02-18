package com.example.interviewitprom.repositories;

import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {
}
