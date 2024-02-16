package com.example.interviewitprom.application.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.junit.jupiter.api.Test;

class EmployeeMapperTest {

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

    var employee = EmployeeMapper.INSTANCE.entityToEmployee(employeeEntity);

    assertEquals(employeeEntity.getId(), employee.getId());
    assertEquals(employeeEntity.getFio(), employee.getFio());
//    assertEquals(employeeEntity.getProfession(), employee.getProfession());
//    assertEquals(employeeEntity.getDepartment(), employee.getDepartment());
    assertEquals(employeeEntity.getNote(), employee.getNote());

  }

  @Test
  void employeeToEntity() {

  }
}