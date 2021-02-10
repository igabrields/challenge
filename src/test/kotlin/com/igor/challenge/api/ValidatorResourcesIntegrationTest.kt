package com.igor.challenge.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class ValidatorResourcesIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun validatorPasswordWithoutInconsistencies() {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/validator/password")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"password\" : \"AbTp9!fok\" } "))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string("{\"password\":\"AbTp9!fok\"," +
                        "\"isValid\":true," +
                        "\"inconsistencies\":[]}"))

    }

    @Test
    fun validatorPasswordWithInconsistencies() {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/validator/password")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"password\" : \"AbTp9zfok\" } "))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(
                        "{\"password\":\"AbTp9zfok\"," +
                                "\"isValid\":false," +
                                "\"inconsistencies\":[\"A senha deve conter ao menos 1 caractere especial: !@#\$%^&*()-+\"]}"
                ))

    }

    @Test
    fun validatorPasswordEmptyBody() {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/validator/password")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest)

    }

    @Test
    fun validatorPasswordPathNotFound() {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/validator")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"password\" : \"AbTp9!fok\" } "))
                .andExpect(MockMvcResultMatchers.status().isNotFound)

    }
}