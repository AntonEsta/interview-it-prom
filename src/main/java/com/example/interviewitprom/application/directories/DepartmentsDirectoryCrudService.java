package com.example.interviewitprom.application.directories;

import com.example.interviewitprom.application.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.model.entities.Employee;
import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentsDirectoryCrudService
    extends JpaDirectoryCrudService<Department, DepartmentEntity> {

  public DepartmentsDirectoryCrudService(
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
