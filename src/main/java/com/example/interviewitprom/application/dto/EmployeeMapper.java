package com.example.interviewitprom.application.dto;

import com.example.interviewitprom.model.entities.Employee;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

  EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  Employee entityToEmployee(EmployeeEntity entity);

  EmployeeEntity employeeToEntity(Employee profession);

}
