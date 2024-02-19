package com.example.interviewitprom.application.directories;

import com.example.interviewitprom.application.directories.interfaces.DirectoryCrudService;
import com.example.interviewitprom.repositories.entities.mappers.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Абстрактный класс реализует дефолтные операции CRUD журнала
 * с {@link JpaRepository}.
 *
 * @param <T> тип записей в журнале.
 * @param <R> тип JPA сущностей.
 */
@RequiredArgsConstructor
public abstract class JpaDirectoryCrudService<T, R> implements DirectoryCrudService<T> {

  /** JPA репозиторий. */
  protected final JpaRepository<R, Long> repository;
  /** Маппер сущностей. */
  protected final EntityMapper<T, R> entityMapper;

  /**
   * Создать запись.
   *
   * @param item запись для внесения в журнал.
   * @return {@code true} - при успешной операции,
   *     {@code false} - при неудачной записи.
   */
  @Override
  public boolean create(T item) {
    var entity = entityMapper.toEntity(item);
    repository.save(entity);
    return true;
  }

  /**
   * Удалить запись.
   *
   * @param item запись для внесения в журнал.
   * @return {@code true} - при успешной операции,
   *     {@code false} - при неудачной записи.
   */
  @Override
  public boolean remove(T item) {
    var entity = entityMapper.toEntity(item);
    repository.delete(entity);
    return true;
  }

  /**
   * Удалить запись по индексу.
   *
   * @param id индекс записи.
   * @return {@code true} - при успешной операции,
   *     {@code false} - при неудачной записи.
   * @throws DataIntegrityViolationException
   */
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

}
