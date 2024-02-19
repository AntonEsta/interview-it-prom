package com.example.interviewitprom.application.directories.departments.services.search;

import com.example.interviewitprom.repositories.entities.mappers.DepartmentMapper;
import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.repositories.DepartmentsRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис поиска по справочнику отделов
 */
@RequiredArgsConstructor
@Service
public class DepartmentsSearchService
    implements DepartmentsDirectorySearchService {

  private final DepartmentsRepository repository;
  private final DepartmentMapper departmentMapper;

  @Override
  public List<Department> getAll() {
    var departmentsEntity = repository.findAll();
    return departmentsEntity.stream()
              .map(departmentMapper::entityTo)
              .toList();
  }

  @Override
  public @Nullable Department getById(long id) {
    var professionEntity = repository.findById(id);
    return professionEntity.map(departmentMapper::entityTo)
        .orElse(null);
  }

}
