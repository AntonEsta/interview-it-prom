package com.example.interviewitprom.application.directories.employees.services.search;

import com.example.interviewitprom.repositories.entities.mappers.EmployeeMapper;
import com.example.interviewitprom.model.entities.Employee;
import com.example.interviewitprom.repositories.EmployeesRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Сервис поиска по справочнику отделов
 */
@RequiredArgsConstructor
@Service
public class EmployeesSearchService
    implements EmployeesDirectorySearchService {

  private final EmployeesRepository repository;
  private final EmployeeMapper employeeMapper;

  @Override
  public List<Employee> getAll() {
    var employeeEntity = repository.findAll();
    return employeeEntity.stream()
              .map(employeeMapper::entityTo)
              .toList();
  }

  @Override
  public @Nullable Employee getById(long id) {
    var employeeEntity = repository.findById(id);
    return employeeEntity.map(employeeMapper::entityTo)
        .orElse(null);
  }

}
