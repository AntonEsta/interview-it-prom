package com.example.interviewitprom.repositories.entities.mappers;

import com.example.interviewitprom.model.entities.Employee;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper
    extends EntityMapper<Employee, EmployeeEntity> {
}
