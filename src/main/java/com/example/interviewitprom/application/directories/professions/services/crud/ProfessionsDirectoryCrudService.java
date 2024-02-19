package com.example.interviewitprom.application.directories.professions.services.crud;

import com.example.interviewitprom.application.directories.JpaDirectoryCrudService;
import com.example.interviewitprom.repositories.entities.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ProfessionsDirectoryCrudService
    extends JpaDirectoryCrudService<Profession, ProfessionEntity> {
  public ProfessionsDirectoryCrudService(
      JpaRepository<ProfessionEntity, Long> repository,
      EntityMapper<Profession, ProfessionEntity> entityMapper) {
    super(repository, entityMapper);
  }
}
