package com.tribesproject.mytribes;

import com.tribesproject.mytribes.DTOs.RegisterDTO;
import com.tribesproject.mytribes.DTOs.RegisterResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.tribesproject.mytribes.appuser.UserController;
import com.tribesproject.mytribes.appuser.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.nio.charset.Charset;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ActiveProfiles(value = "test")
public class UserControllerTest {
  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RegisterService registerService;

  @Test
  public void addNewUser_succesful() throws Exception {
    RegisterDTO registerDTO = new RegisterDTO("test", "12345", "galactic empire");
    RegisterResponseDTO registerResponseDTO = new RegisterResponseDTO(1L, "test", 1L);
    when(registerService.createNewUser(any())).thenReturn(ResponseEntity.status(200).body(registerResponseDTO));
//    when(registerService.createNewUser(tribeUser)).thenReturn(ResponseEntity.status(200).body(registerResponseDTO));
    mockMvc.perform(post("/register")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\"username\": \"test\", \"password\": \"12345\", \"kingdom\": \"galactic empire\"}"))
        .andExpect(status().isOk())
//        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.username", is("test")))
        .andExpect(jsonPath("$.kingdomId", is(1)));
  }
}

