package com.nriker.switter;

import static org.mockito.Mockito.when;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

@WebMvcTest(SwitterUserController.class)
public class SwitterUserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    private final String userName = "userName1";

    @MockBean
    private SwitterUserRepository usersRepository;

    @MockBean
    private SwitterUserService switterUserService;

    @Test
    public void SwitterUserControllerTest() throws Exception {
        SwitterUser switterUser = new SwitterUser("1", userName, "123");
        when(usersRepository.findUser(userName)).thenReturn(switterUser);

        mockMvc.perform(MockMvcRequestBuilders
        .get("/api/v1/user/" + userName)
        .accept(APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print())
        // .andExpect(jsonPath("$.name").value(userName))
        ;
    }
}
