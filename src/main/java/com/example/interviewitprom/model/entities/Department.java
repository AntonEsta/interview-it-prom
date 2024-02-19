package com.example.interviewitprom.model.entities;

import lombok.Value;

/**
 * Класс описывает отдел организации.
 */
@Value
public class Department {
  /** Идентификатор отдела. */
  Long id;
  /** Наименование отдела. */
  String name;
  /** Примечание. */
  String note;
  /** Родительский отдел. */
  Department parentDepartment;
}
