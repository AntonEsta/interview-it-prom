package com.example.interviewitprom.controllers.professions.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.interviewitprom.application.mappers.EmployeeMapper;
import com.example.interviewitprom.controllers.professions.dto.ProfessionRequestDto;
import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import com.example.interviewitprom.repositories.entities.EmployeeEntity;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfessionRequestMapperTest {

  @Autowired
  ProfessionRequestMapper professionRequestMapper;

  @Test
  void requestToProfession() {
    var dto = new ProfessionRequestDto(1L,
        "Programmer",
        "Simple note!");

    var profession = professionRequestMapper.requestToProfession(dto);

    assertEquals(profession.getId(), dto.id());
    assertEquals(profession.getName(), dto.name());
    assertEquals(profession.getNote(), dto.note());

  }

}