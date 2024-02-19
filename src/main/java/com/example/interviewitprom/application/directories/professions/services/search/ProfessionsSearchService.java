package com.example.interviewitprom.application.directories.professions.services.search;

import com.example.interviewitprom.repositories.entities.mappers.ProfessionMapper;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.ProfessionsRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис поиска по справочнику должностей
 */
@RequiredArgsConstructor
@Service
public class ProfessionsSearchService
    extends ProfessionsDirectorySearchService {

  private final ProfessionsRepository repository;
  private final ProfessionMapper professionMapper;


  @Override
  public List<Profession> getAll() {
    var professionsEntity = repository.findAll();
    return professionsEntity.stream()
              .map(professionMapper::entityTo)
              .toList();
  }

  @Override
  public @Nullable Profession getById(long id) {
    var professionEntity = repository.findById(id);
    return professionEntity.map(professionMapper::entityTo)
        .orElse(null);
  }

}
