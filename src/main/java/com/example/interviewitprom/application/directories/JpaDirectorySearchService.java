package com.example.interviewitprom.application.directories;

import com.example.interviewitprom.application.directories.professions.services.search.ProfessionsDirectorySearchService;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.ProfessionsRepository;
import com.example.interviewitprom.repositories.entities.mappers.ProfessionMapper;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Абстрактный класс реализует дефолтные операции CRUD журнала
 * с {@link JpaRepository}.
 */
@RequiredArgsConstructor
public class JpaDirectorySearchService
    extends ProfessionsDirectorySearchService {

  private final ProfessionsRepository repository;
  private final ProfessionMapper professionMapper;

  /**
   * Получить все записи из журнала.
   *
   * @return список записей в виде коллекции {@link List}.
   */
  @Override
  public List<Profession> getAll() {
    var professionsEntity = repository.findAll();
    return professionsEntity.stream()
              .map(professionMapper::entityTo)
              .toList();
  }

  /**
   * Получить одну запись из журнала.
   *
   * @param id индекс записи в журнале.
   * @return запись журнала.
   */
  @Override
  public @Nullable Profession getById(long id) {
    var professionEntity = repository.findById(id);
    return professionEntity.map(professionMapper::entityTo)
        .orElse(null);
  }

}
