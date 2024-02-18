package com.example.interviewitprom.controllers.department.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NonNull;

public record DepartmentRequestDto(
    @Positive
    Long id,
    @NotNull
    @NotEmpty
    String name,
    @NonNull
    Long parentDepartmentId,
    String note) {
}
