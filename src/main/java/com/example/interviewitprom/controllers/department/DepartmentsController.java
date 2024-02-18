package com.example.interviewitprom.controllers.department;

import com.example.interviewitprom.application.directories.DepartmentsDirectoryCrudService;
import com.example.interviewitprom.application.directories.departments.DepartmentsDirectorySearchService;
import com.example.interviewitprom.controllers.department.dto.DepartmentRequestDto;
import com.example.interviewitprom.controllers.department.mappers.DepartmentRequestMapper;
import com.example.interviewitprom.controllers.employee.dto.EmployeeRequestDto;
import com.example.interviewitprom.controllers.employee.mappers.EmployeeRequestMapper;
import com.example.interviewitprom.model.entities.Department;
import com.example.interviewitprom.model.entities.Employee;
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
@RequestMapping("/api/v1/departments")
public class DepartmentsController {

  private final DepartmentsDirectoryCrudService directoryCrudService;
  private final DepartmentsDirectorySearchService departmentsSearchService;
  private final DepartmentRequestMapper departmentRequestMapper;

  @GetMapping
  public ResponseEntity<List<Department>> getAll() {
    var department = departmentsSearchService.getAll();
    return ResponseEntity.ok(department);
  }

  @GetMapping(params = {"id"})
  public ResponseEntity<Department> getOne(@RequestParam("id") long id) {
    var department = departmentsSearchService.getById(id);
    return ResponseEntity.ok(department);
  }

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
  public HttpStatus create(@Valid @RequestBody
                           DepartmentRequestDto departmentRequestDto,
                           @NonNull BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return HttpStatus.BAD_REQUEST;
    }
    var department = departmentRequestMapper.requestToDepartment(departmentRequestDto);
    directoryCrudService.create(department);
    return  HttpStatus.OK;
  }

  @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public HttpStatus update(@PathVariable("id") long id,
                           @Valid @RequestBody
                           DepartmentRequestDto departmentRequestDto,
                           @NonNull BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return HttpStatus.BAD_REQUEST;
    }
    var department = departmentRequestMapper.requestToDepartment(departmentRequestDto);
    directoryCrudService.update(id, department);
    return HttpStatus.OK;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") long id) {
    if (id < 1) {
      return ResponseEntity.badRequest()
          .body("Значение индекса не может быть меньше 1.");
    }
    try {
      if (!directoryCrudService.remove(id)) {
        return ResponseEntity.badRequest().body("Удаление невозможно.");
      }
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    return ResponseEntity.ok().build();
  }

}
