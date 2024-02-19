package com.example.interviewitprom.model.entities;

import lombok.Value;

/**
 * Класс описывает сотрудника организации.
 */
@Value
public class Employee {
  /** Идентификатор сотрудника. */
  Long id;
  /** Фамилия, имя и отчество (при наличии) сотрудника. */
  String fio;
  /** Профессия сотрудника. */
  Profession profession;
  /** Отдел организации в котором состоит сотрудник. */
  Department department;
  /** Примечание. */
  String note;
}
