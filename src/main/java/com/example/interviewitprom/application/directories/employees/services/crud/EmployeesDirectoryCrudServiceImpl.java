package com.example.interviewitprom.application.directories.employees.services.crud;

import com.example.interviewitprom.repositories.entities.mappers.EntityMapper;
import com.example.interviewitprom.model.entities.Employee;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeesDirectoryCrudServiceImpl
    extends EmployeesDirectoryCrudService {

  public EmployeesDirectoryCrudServiceImpl(
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
