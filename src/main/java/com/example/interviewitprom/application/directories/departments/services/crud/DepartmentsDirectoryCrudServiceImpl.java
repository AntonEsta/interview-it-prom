package com.example.interviewitprom.application.directories.departments.services.crud;

import com.example.interviewitprom.repositories.entities.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsDirectoryCrudServiceImpl
    extends DepartmentsDirectoryCrudService {

  public DepartmentsDirectoryCrudServiceImpl(
      JpaRepository<DepartmentEntity, Long> repository,
      EntityMapper<Department, DepartmentEntity> entityMapper) {
    super(repository, entityMapper);
  }

  @Override
  public boolean update(Long id, Department department) {
    var entity = entityMapper.toEntity(department);
    if ( repository.existsById(department.getId()) ) {
      repository.save(entity);
    }
    return true;
  }
}
