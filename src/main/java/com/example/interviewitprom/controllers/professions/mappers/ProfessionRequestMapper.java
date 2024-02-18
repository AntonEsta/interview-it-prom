package com.example.interviewitprom.controllers.professions.mappers;

import com.example.interviewitprom.controllers.professions.dto.ProfessionRequestDto;
import com.example.interviewitprom.model.entities.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfessionRequestMapper {

  Profession requestToProfession(ProfessionRequestDto entity);

}
