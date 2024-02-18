package com.example.interviewitprom.application.mappers;

import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.repositories.entities.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EntityMapper<T,R> {

  T entityTo(R entity);

  R toEntity(T department);

}
