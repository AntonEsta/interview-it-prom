package com.example.interviewitprom.application;

import com.example.interviewitprom.application.dto.ProfessionMapper;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.ProfessionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис создания, обновления и удаления должностей справочника
 */
@RequiredArgsConstructor
@Service
public class ProfessionsCrudService
    implements ProfessionsDirectoryCrudService {

  private final ProfessionsRepository repository;

  @Override
  public boolean add(Profession profession) {
    var entity = ProfessionMapper.INSTANCE.professionToEntity(profession);
    entity = repository.save(entity);
    return true;
  }

  @Override
  public boolean remove(Profession profession) {
    var entity = ProfessionMapper.INSTANCE.professionToEntity(profession);
    repository.delete(entity);
    return true;
  }

  public boolean remove(Long id) throws DataIntegrityViolationException {
    var found = repository.findById(id);
    if (found.isEmpty()) {
      return false;
    }
    var entity = found.get();
    try {
      repository.delete(entity);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("Невозможно удалить данные,"
          + "так как они задействованы в других справочниках.");
    }
    return true;
  }

  @Override
  public boolean update(Profession profession) {
    var entity = ProfessionMapper.INSTANCE.professionToEntity(profession);
    if ( repository.existsById(profession.getId()) ) {
      repository.save(entity);
    }
    return true;
  }

}
