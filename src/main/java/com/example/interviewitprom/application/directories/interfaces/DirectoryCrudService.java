package com.example.interviewitprom.application.directories.interfaces;

import org.springframework.dao.DataIntegrityViolationException;

public interface DirectoryCrudService<T> {

  boolean create(T item);
  boolean remove(T item);
  boolean update(Long id, T item);
  boolean remove(Long id) throws DataIntegrityViolationException;

}
