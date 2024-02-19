package com.example.interviewitprom.controllers.employee;

import com.example.interviewitprom.application.directories.employees.services.crud.EmployeesDirectoryCrudService;
import com.example.interviewitprom.application.directories.employees.services.search.EmployeesDirectorySearchService;
import com.example.interviewitprom.controllers.employee.dto.EmployeeRequestDto;
import com.example.interviewitprom.controllers.employee.mappers.EmployeeRequestMapper;
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
@RequestMapping("/api/v1/employees")
public class EmployeesController {

  private final EmployeesDirectoryCrudService employeesService;
  private final EmployeesDirectorySearchService employeesSearchService;
  private final EmployeeRequestMapper employeeRequestMapper;

  @GetMapping
  public ResponseEntity<List<Employee>> getAll() {
    var employee = employeesSearchService.getAll();
    return ResponseEntity.ok(employee);
  }

  @GetMapping(params = {"id"})
  public ResponseEntity<Employee> getOne(@RequestParam("id") long id) {
    var employee = employeesSearchService.getById(id);
    return ResponseEntity.ok(employee);
  }

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
  public HttpStatus create(@Valid @RequestBody
                           EmployeeRequestDto employeeRequestDto,
                           @NonNull BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return HttpStatus.BAD_REQUEST;
    }
    var employee = employeeRequestMapper.requestToEmployee(employeeRequestDto);
    employeesService.create(employee);
    return  HttpStatus.OK;
  }

  @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public HttpStatus update(@PathVariable("id") long id,
                           @Valid @RequestBody
                           EmployeeRequestDto employeeRequestDto,
                           @NonNull BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return HttpStatus.BAD_REQUEST;
    }
    var employee = employeeRequestMapper.requestToEmployee(employeeRequestDto);
//        EmployeeRequestMapper.INSTANCE
//        .requestToEmployee(employeeRequestDto);
    employeesService.update(id, employee);
    return HttpStatus.OK;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") long id) {
    if (id < 1) {
      return ResponseEntity.badRequest()
          .body("Значение индекса не может быть меньше 1.");
    }
    try {
      if (!employeesService.remove(id)) {
        return ResponseEntity.badRequest().body("Удаление невозможно.");
      }
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    return ResponseEntity.ok().build();
  }

}
