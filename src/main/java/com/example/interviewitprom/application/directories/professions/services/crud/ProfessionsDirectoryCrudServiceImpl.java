package com.example.interviewitprom.application.directories.professions.services.crud;

import com.example.interviewitprom.repositories.entities.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessionsDirectoryCrudServiceImpl
    extends ProfessionsDirectoryCrudService {

  public ProfessionsDirectoryCrudServiceImpl(
      JpaRepository<ProfessionEntity, Long> repository,
      EntityMapper<Profession, ProfessionEntity> entityMapper) {
    super(repository, entityMapper);
  }

  @Override
  public boolean update(Long id, Profession profession) {
    var entity = entityMapper.toEntity(profession);
    if ( repository.existsById(profession.getId()) ) {
      repository.save(entity);
    }
    return true;
  }
}
