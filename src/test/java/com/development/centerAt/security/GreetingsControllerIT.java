package com.development.centerAt.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class GreetingsControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    void greetingsTest_whenAnonymousUser_thenReturnStatusIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    @WithAnonymousUser
    void greetingsUserTest_whenMockAnonymousUser_thenReturnStatusIsFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/home")).andExpect(MockMvcResultMatchers.status().isFound());
    }

    @Test
    @WithMockUser(authorities = {"ROLE_USER", "ROLE_ADMIN"})
    void greetingsUserTest_whenMockUserWithUserRole_thenReturnStatusIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/home")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(authorities = "ROLE_USER")
    void greetingsAdmin_whenMockUserWithUserRole_thenReturnStatusUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/home")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(authorities = "ROLE_ADMIN")
    void greetingsAdmin_whenMockUserWithAdminRole_thenReturnStatusIsOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/home")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
