package com.example.interviewitprom.application.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.interviewitprom.application.mappers.EmployeeMapper;
import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeMapperTest {

  @Autowired
  EmployeeMapper employeeMapper;

  @Test
  void entityToEmployee() {
    ProfessionEntity professionEntity = new ProfessionEntity();
    professionEntity.setId(1L);
    professionEntity.setName("Programmer");
    professionEntity.setNote("Note");

    DepartmentEntity departmentEntity = new DepartmentEntity();
    departmentEntity.setId(1L);
    departmentEntity.setParentDepartment(null);
    departmentEntity.setNote("Note");

    EmployeeEntity employeeEntity = new EmployeeEntity();
    employeeEntity.setId(1L);
    employeeEntity.setFio("Jack Jackson");
    employeeEntity.setProfession(professionEntity);
    employeeEntity.setDepartment(departmentEntity);
    employeeEntity.setNote("Simple note!");

    var employee = employeeMapper.entityTo(employeeEntity);

    assertEquals(employeeEntity.getId(), employee.getId());
    assertEquals(employeeEntity.getFio(), employee.getFio());
    assertEquals(employeeEntity.getNote(), employee.getNote());

  }

  @Test
  void employeeToEntity() {

  }
}