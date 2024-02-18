package com.example.interviewitprom.controllers.professions.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProfessionRequestDto(
    @Positive
    Long id,
    @NotNull
    @NotEmpty
    String name,
    @NotNull
    String note) {
}
