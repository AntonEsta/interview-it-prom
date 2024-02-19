package com.example.interviewitprom.model.entities;

import lombok.Value;

/**
 * Класс описывает профессию в организации.
 */
@Value
public class Profession {
  /** Идентификатор профессии. */
  Long id;
  /** Наименование профессии. */
  String name;
  /** Примечание. */
  String note;
}
