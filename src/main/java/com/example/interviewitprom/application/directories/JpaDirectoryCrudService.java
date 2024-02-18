package com.example.interviewitprom.application.directories;

import com.example.interviewitprom.application.directories.interfaces.DirectoryCrudService;
import com.example.interviewitprom.application.mappers.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public abstract class JpaDirectoryCrudService<T, R> implements DirectoryCrudService<T> {

  protected final JpaRepository<R, Long> repository;
  protected final EntityMapper<T, R> entityMapper;

  @Override
  public boolean create(T item) {
    var entity = entityMapper.toEntity(item);
    repository.save(entity);
    return true;
  }

  @Override
  public boolean remove(T item) {
    var entity = entityMapper.toEntity(item);
    repository.delete(entity);
    return true;
  }

  public boolean remove(Long id) throws DataIntegrityViolationException {
    var found = repository.findById(id);
    if (found.isEmpty()) {
      return false;
    }
    var entity = found.get();
    try {
      repository.delete(entity);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("Невозможно удалить данные,"
          + "так как они задействованы в других справочниках.");
    }
    return true;
  }



//  @Override
//  public boolean update(Long id, T item) {
//    var entity = professionMapper.toEntity(item);
//    if ( repository.existsById(item.getId()) ) {
//      repository.save(entity);
//    }
//    return true;
//  }
}
