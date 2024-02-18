package com.example.interviewitprom.repositories;

import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionsRepository extends JpaRepository<ProfessionEntity, Long> {
}
