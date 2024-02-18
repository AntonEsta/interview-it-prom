package com.example.interviewitprom.application.mappers;

import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.model.entities.Profession;
import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import com.example.interviewitprom.repositories.entities.ProfessionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper extends EntityMapper<Department, DepartmentEntity> {
}
