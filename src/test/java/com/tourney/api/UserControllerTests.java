package com.tourney.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tourney.api.models.User;
import com.tourney.api.repositories.UserRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class UserControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        assertThat(mvc).isNotNull();
        assertThat(objectMapper).isNotNull();
        assertThat(userRepository).isNotNull();
    }

    @Test
    public void whenAddUser_thenStatus200() throws Exception {
        User user = new User();
        user.setEmail("test1@test.nl");

        mvc.perform(post("/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("User added"));

        Optional<User> addedUser = userRepository.findByEmail("test1@test.nl");
        assertThat(addedUser.isPresent()).isEqualTo(true);
    }

//    @Test
//    public void whenGetUser_thenStatus200() throws Exception {
//        User user = new User();
//        user.setUsername("test3");
//        user.setEmail("test3@test.nl");
//
//        mvc.perform(post("/users")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(user)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").value("Saved"));
//
//        Optional<User> addedUser = userRepository.findOneByUsername("test3");
//        assertThat(addedUser.isPresent()).isEqualTo(true);
//
//        if (addedUser.isPresent()) {
//            mvc.perform(get("/users")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .param("id", addedUser.get().getId().toString()))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$.username").value("test3"));
//        }
//    }
}
