package com.example.interviewitprom.application.directories.interfaces;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * Интерфейс описывает операции создания, редактирования, удаления для журналов.
 *
 * @param <T> тип записей хранящихся в журнале.
 */
public interface DirectoryCrudService<T> {

  /**
   * Создать запись.
   *
   * @param item запись для внесения в журнал.
   * @return {@code true} - при успешной операции,
   *      {@code false} - при неудачной записи.
   */
  boolean create(T item);

  /**
   * Удалить запись.
   *
   * @param item запись для внесения в журнал.
   * @return {@code true} - при успешной операции,
   *     {@code false} - при неудачной записи.
   */
  boolean remove(T item);

  /**
   * Обновить (перезаписать) запись.
   *
   * @param id индекс записи.
   * @param item запись для внесения в журнал.
   * @return {@code true} - при успешной операции,
   *     {@code false} - при неудачной записи.
   */
  boolean update(Long id, T item);

  /**
   * Удалить запись по индексу.
   *
   * @param id индекс записи.
   * @return {@code true} - при успешной операции,
   *     {@code false} - при неудачной записи.
   * @throws DataIntegrityViolationException
   */
  boolean remove(Long id) throws DataIntegrityViolationException;

}
