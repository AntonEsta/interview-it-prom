package com.example.interviewitprom.application;

import org.springframework.dao.DataIntegrityViolationException;

public interface DirectoryCrudService<T> {

  boolean add(T item);
  boolean remove(T item);
  boolean remove(Long id) throws DataIntegrityViolationException;
  boolean update(T item);

}
