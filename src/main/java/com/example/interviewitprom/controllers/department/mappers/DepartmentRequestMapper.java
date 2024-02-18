package com.example.interviewitprom.controllers.department.mappers;

import com.example.interviewitprom.application.directories.departments.DepartmentsSearchService;
import com.example.interviewitprom.controllers.department.dto.DepartmentRequestDto;
import com.example.interviewitprom.model.entities.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class DepartmentRequestMapper {

  @Autowired
  protected DepartmentsSearchService departmentsSearchService;


  public Department requestToDepartment(DepartmentRequestDto requestDto) {
    var department = departmentsSearchService.getById(requestDto.parentDepartmentId());
    return new Department(requestDto.id(), requestDto.name(),
        requestDto.note(), department);
  }

}
