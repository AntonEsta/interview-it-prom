package com.example.interviewitprom.application.directories.interfaces;

import java.util.List;

/**
 * Интерфейс описывает операции поиска по журналам.
 *
 * @param <T> тип записей хранящихся в журнале.
 */
public interface DirectorySearchService<T> {

  /**
   * Получить все записи из журнала.
   *
   * @return список записей в виде коллекции {@link List}.
   */
  List<T> getAll();

  /**
   * Получить одну запись из журнала.
   *
   * @param id индекс записи в журнале.
   * @return запись журнала.
   */
  T getById(long id);

}
