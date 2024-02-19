package com.example.interviewitprom.repositories.entities.mappers;

public interface EntityMapper<T,R> {

  T entityTo(R entity);

  R toEntity(T department);

}
