package com.example.interviewitprom.controllers.employee.dto;

import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.model.entities.Profession;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;

public record EmployeeRequestDto(
    @Positive
    Long id,
    @NotNull
    @NotEmpty
    String fio,
    @NonNull
    Long professionId,
    @NonNull
    Long departmentId,
    String note) {
}
