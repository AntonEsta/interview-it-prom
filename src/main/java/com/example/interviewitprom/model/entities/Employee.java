package com.example.interviewitprom.model.entities;

import lombok.Value;

@Value
public class Employee {
  Long id;
  String fio;
  Profession profession;
  Department department;
  String note;

}
