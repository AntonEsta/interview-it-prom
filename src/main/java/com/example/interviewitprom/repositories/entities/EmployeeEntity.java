package com.example.interviewitprom.repositories.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "EMPLOYEES")
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column(name = "FIO", nullable = false)
  String fio;

  @ManyToOne
  @JoinColumn(name = "PROFESSION_ID")
  ProfessionEntity profession;

  @ManyToOne
  @JoinColumn(name = "DEPARTMENT_ID")
  DepartmentEntity department;

  @Column(name = "NOTE")
  String note;

}
