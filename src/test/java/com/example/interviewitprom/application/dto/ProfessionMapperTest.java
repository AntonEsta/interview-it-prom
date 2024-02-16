package com.example.interviewitprom.application.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.junit.jupiter.api.Test;

class ProfessionMapperTest {

  @Test
  void entityToProfession() {
    ProfessionEntity entity = new ProfessionEntity();
    entity.setId(1L);
    entity.setName("Programmer");
    entity.setNote("Simple note!");

    var prof = ProfessionMapper.INSTANCE.entityToProfession(entity);
    assertEquals(entity.getId(), prof.getId());
    assertEquals(entity.getName(), prof.getName());
    assertEquals(entity.getNote(), prof.getNote());
  }

  @Test
  void professionToEntity() {
  }
}