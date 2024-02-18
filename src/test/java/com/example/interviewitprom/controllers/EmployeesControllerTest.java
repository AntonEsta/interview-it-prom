package com.example.interviewitprom.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
class EmployeesControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Value("/${server.api.url}/${server.api.version}")
  private String apiUrl;
  private String controllerUrl;

  @BeforeEach
  void beforeEach() {
    this.controllerUrl = this.apiUrl + "/employees";
  }

  @Test
  void getAll() throws Exception {
    this.mockMvc
        .perform(get(controllerUrl))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void getOne() throws Exception {
    this.mockMvc
        .perform(get(controllerUrl + "?id=1"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void create() throws Exception {
    String body = "{\"id\": 30,\"fio\":\"Иванов Иван Иванович\","
        + "\"professionId\":1,\"departmentId\":1,\"note\":\"Note\"}";
    this.mockMvc
        .perform(post(controllerUrl)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.ALL_VALUE)
                .content(body))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void update() throws Exception {
    String body = "{\"id\": 30,\"fio\":\"Иванов Иван Иванович\","
        + "\"professionId\":1,\"departmentId\":1,\"note\":\"Note\"}";
    this.mockMvc
        .perform(put(controllerUrl + "/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .content(body))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void remove() throws Exception {
    this.mockMvc
        .perform(delete(controllerUrl + "/3"))
        .andDo(print())
        .andExpect(status().isOk());
  }
}