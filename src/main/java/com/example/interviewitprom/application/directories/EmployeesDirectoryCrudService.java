package com.example.interviewitprom.application.directories;

import com.example.interviewitprom.application.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Employee;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeesDirectoryCrudService
    extends JpaDirectoryCrudService<Employee, EmployeeEntity> {

  public EmployeesDirectoryCrudService(
      JpaRepository<EmployeeEntity, Long> repository,
      EntityMapper<Employee, EmployeeEntity> entityMapper) {
    super(repository, entityMapper);
  }

  @Override
  public boolean update(Long id, Employee employee) {
    var entity = entityMapper.toEntity(employee);
    if ( repository.existsById(employee.getId()) ) {
      repository.save(entity);
    }
    return true;
  }
}
