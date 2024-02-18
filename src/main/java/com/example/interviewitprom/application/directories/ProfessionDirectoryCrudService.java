package com.example.interviewitprom.application.directories;

import com.example.interviewitprom.application.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessionDirectoryCrudService
    extends JpaDirectoryCrudService<Profession, ProfessionEntity> {

  public ProfessionDirectoryCrudService(
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
