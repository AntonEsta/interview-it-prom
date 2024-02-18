package com.example.interviewitprom.controllers.professions;

import com.example.interviewitprom.application.directories.ProfessionDirectoryCrudService;
import com.example.interviewitprom.application.directories.interfaces.DirectoryCrudService;
import com.example.interviewitprom.application.directories.professions.ProfessionsDirectorySearchService;
import com.example.interviewitprom.controllers.professions.dto.ProfessionRequestDto;
import com.example.interviewitprom.controllers.professions.mappers.ProfessionRequestMapper;
import com.example.interviewitprom.model.entities.Profession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/professions")
public class ProfessionsController {

  private final ProfessionDirectoryCrudService professionsService;
  private final ProfessionsDirectorySearchService professionsSearchService;
  private final ProfessionRequestMapper professionRequestMapper;

  @GetMapping
  public ResponseEntity<List<Profession>> getAll() {
    var professions = professionsSearchService.getAll();
    return ResponseEntity.ok(professions);
  }

  @GetMapping(params = {"id"})
  public ResponseEntity<Profession> getOne(@RequestParam("id") long id) {
    var profession = professionsSearchService.getById(id);
    return ResponseEntity.ok(profession);
  }

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
  public HttpStatus create(@Valid @RequestBody
                           ProfessionRequestDto professionRequestDto,
                           @NonNull BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return HttpStatus.BAD_REQUEST;
    }
    var profession = professionRequestMapper
        .requestToProfession(professionRequestDto);
    professionsService.create(profession);
    return  HttpStatus.OK;
  }

  @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public HttpStatus update(@PathVariable("id") long id,
                           @Valid @RequestBody
                           ProfessionRequestDto professionRequestDto,
                           @NonNull BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return HttpStatus.BAD_REQUEST;
    }
    var profession = professionRequestMapper
        .requestToProfession(professionRequestDto);
    professionsService.update(id, profession);
    return HttpStatus.OK;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") long id) {
    if (id < 1) {
      return ResponseEntity.badRequest()
          .body("Значение индекса не может быть меньше 1.");
    }
    try {
      if (!professionsService.remove(id)) {
        return ResponseEntity.badRequest().body("Удаление невозможно.");
      }
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    return ResponseEntity.ok().build();
  }

}
