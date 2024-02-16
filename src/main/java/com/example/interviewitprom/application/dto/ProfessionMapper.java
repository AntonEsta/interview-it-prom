package com.example.interviewitprom.application.dto;

import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionMapper {

  ProfessionMapper INSTANCE = Mappers.getMapper(ProfessionMapper.class);

  Profession entityToProfession(ProfessionEntity entity);

  ProfessionEntity professionToEntity(Profession profession);

}
