package com.example.interviewitprom.controllers.employee.mappers;

import com.example.interviewitprom.application.directories.departments.DepartmentsSearchService;
import com.example.interviewitprom.application.directories.professions.ProfessionsSearchService;
import com.example.interviewitprom.controllers.employee.dto.EmployeeRequestDto;
import com.example.interviewitprom.model.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class EmployeeRequestMapper {

  @Autowired
  protected ProfessionsSearchService professionsSearchService;
  @Autowired
  protected DepartmentsSearchService departmentsSearchService;


  public Employee requestToEmployee(EmployeeRequestDto requestDto) {
    var profession = professionsSearchService.getById(requestDto.professionId());
    var department = departmentsSearchService.getById(requestDto.departmentId());
    return new Employee(requestDto.id(), requestDto.fio(), profession,
        department, requestDto.note());
  }

}
