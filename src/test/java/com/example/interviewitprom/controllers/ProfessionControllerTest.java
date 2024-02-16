package com.example.interviewitprom.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProfessionControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void getAll() throws Exception {
    this.mockMvc
        .perform(get("/api/v1/profession"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void add() throws Exception {
    String body = "{\"id\": 30, \"name\": Name, \"note\": Note}";
    this.mockMvc
        .perform(post("/api/v1/profession")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void remove() throws Exception {
    this.mockMvc
        .perform(delete("/api/v1/profession/3"))
        .andDo(print())
        .andExpect(status().isBadRequest());
  }
}