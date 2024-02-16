package com.example.interviewitprom.controllers;

import com.example.interviewitprom.application.ProfessionsDirectoryCrudService;
import com.example.interviewitprom.application.ProfessionsDirectorySearchService;
import com.example.interviewitprom.model.entities.Profession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/profession")
public class ProfessionController {

  private final ProfessionsDirectoryCrudService professionsService;
  private final ProfessionsDirectorySearchService professionsSearchService;

  @GetMapping
  public ResponseEntity<List<Profession>> getAll() {
    var professions = professionsSearchService.getAll();
    return ResponseEntity.ok(professions);
  }

  @PostMapping
  public ResponseEntity.BodyBuilder add(@Valid @RequestBody Profession profession,
                                        BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest();
    } else {
      professionsService.add(profession);
    }
    return ResponseEntity.ok();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity.BodyBuilder remove(@PathVariable Long id) {
    if (id < 1) {
      ResponseEntity.badRequest();
    }
    if (!professionsService.remove(id)) {
      return ResponseEntity.badRequest();
    }
    return ResponseEntity.ok();
  }

}
