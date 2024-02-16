package com.example.interviewitprom.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode

@Entity
@Table(name = "DEPARTMENTS")
public class DepartmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "DEPARTMENT_ID")
  long id;

  @NotNull
  @NotEmpty
  @Column(name = "NAME", nullable = false)
  String name;

  @Column(name = "NOTE")
  String note;

  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  DepartmentEntity parentDepartment;

}
