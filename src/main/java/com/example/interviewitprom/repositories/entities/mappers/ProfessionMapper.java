package com.example.interviewitprom.repositories.entities.mappers;

import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfessionMapper
    extends EntityMapper<Profession, ProfessionEntity> {
}
