package com.example.interviewitprom.application.directories.departments.services.crud;

import com.example.interviewitprom.application.directories.JpaDirectoryCrudService;
import com.example.interviewitprom.repositories.entities.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class DepartmentsDirectoryCrudService
    extends JpaDirectoryCrudService<Department, DepartmentEntity> {
  public DepartmentsDirectoryCrudService(
      JpaRepository<DepartmentEntity, Long> repository,
      EntityMapper<Department, DepartmentEntity> entityMapper) {
    super(repository, entityMapper);
  }
}
