package com.tourney.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tourney.api.models.User;
import com.tourney.api.repositories.TournamentRepository;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class TournamentControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Test
    public void contextLoads() {
        assertThat(mvc).isNotNull();
        assertThat(objectMapper).isNotNull();
        assertThat(tournamentRepository).isNotNull();
    }

//    @Test
//    public void whenAddUser_thenStatus200() throws Exception {
//        User user = new User();
//        user.setEmail("test1@test.nl");
//
//        mvc.perform(post("/getTeams")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(user)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").value("User added"));
//
//        Optional<User> addedUser = userRepository.findByEmail("test1@test.nl");
//        assertThat(addedUser.isPresent()).isEqualTo(true);
//    }
}
