package com.example.interviewitprom.application;

import com.example.interviewitprom.application.dto.ProfessionMapper;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.ProfessionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис поиска по справочнику должностей
 */
@RequiredArgsConstructor
@Service
public class ProfessionsSearchService
    implements ProfessionsDirectorySearchService {

  private final ProfessionsRepository repository;

  @Override
  public List<Profession> getAll() {
    var professionsEntity = repository.findAll();
    return professionsEntity.stream()
              .map(ProfessionMapper.INSTANCE::entityToProfession)
              .toList();
  }

}
