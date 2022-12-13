package com.nriker.switter;

import static org.mockito.Mockito.when;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nriker.switter.controller.SwitterUserController;
import com.nriker.switter.model.SwitterUser;
import com.nriker.switter.persistance.SwitterUserRepository;
import com.nriker.switter.service.SwitterUserService;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.assertj.core.api.Assertions.assertThat;

//SpringRunner - Enviroment, die unsere Tests startet.
// @RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @WebMvcTest(SwitterUserController.class)
public class SwitterUserControllerTests {
    @LocalServerPort
    private int port;

    @Autowired
    private SwitterUserController switterUserController;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void userControllerTest() throws Exception {
        assertThat(switterUserController).isNotNull();
    }

    @Test
    public void helloWorldTest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:"
         + port + "/api/v1/user/hello",
				String.class)).contains("Hello, World");
	}

    //     @Autowired
//     private MockMvc mockMvc;

//     private final String userName = "userName1";

//     @MockBean
//     private SwitterUserRepository usersRepository;

//     @MockBean
//     private SwitterUserService switterUserService;

//     @Test
//     public void SwitterUserControllerTest() throws Exception {
//         // SwitterUser switterUser = new SwitterUser("1", userName, "123");
//         // when(usersRepository.findUser(userName)).thenReturn(switterUser);

//         mockMvc.perform(MockMvcRequestBuilders
//         .get("/api/v1/user/" + userName)
//         .accept(APPLICATION_JSON))
//         .andExpect(status().isOk())
//         .andDo(print())
//         // .andExpect(jsonPath("$.name").value(userName))
//         ;
//     }
}
