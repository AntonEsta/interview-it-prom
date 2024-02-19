package com.example.interviewitprom.application.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.example.interviewitprom.repositories.entities.mappers.ProfessionMapper;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfessionMapperTest {

  @Autowired
  ProfessionMapper professionMapper;

  @Test
  void entityToProfession() {
    ProfessionEntity entity = new ProfessionEntity();
    entity.setId(1L);
    entity.setName("Programmer");
    entity.setNote("Simple note!");

    var prof = professionMapper.entityTo(entity);
    assertEquals(entity.getId(), prof.getId());
    assertEquals(entity.getName(), prof.getName());
    assertEquals(entity.getNote(), prof.getNote());
  }

  @Test
  void professionToEntity() {
  }
}