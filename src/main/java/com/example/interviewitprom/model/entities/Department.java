package com.example.interviewitprom.model.entities;

import lombok.Value;

@Value
public class Department {
  Long id;
  String name;
  String note;
  Department parentDepartment;

}
