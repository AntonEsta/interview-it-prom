package com.example.interviewitprom.application.directories.employees.services.crud;

import com.example.interviewitprom.application.directories.JpaDirectoryCrudService;
import com.example.interviewitprom.repositories.entities.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Employee;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class EmployeesDirectoryCrudService
    extends JpaDirectoryCrudService<Employee, EmployeeEntity> {
  public EmployeesDirectoryCrudService(
      JpaRepository<EmployeeEntity, Long> repository,
      EntityMapper<Employee, EmployeeEntity> entityMapper) {
    super(repository, entityMapper);
  }
}
