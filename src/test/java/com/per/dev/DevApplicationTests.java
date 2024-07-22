/*
package com.per.dev;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DevApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sayHelloEndpointReturnsCorrectMessage() throws Exception {
        // Assuming the default locale is US and the message for "welcome.message" in messages.properties is "Welcome to our application!"
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to our application!"));
    }

    @Test
    public void myTimeEndpointReturnsResponse() throws Exception {
        // This test checks that the endpoint is reachable and returns a status of 200 OK.
        // It does not assert the content of the response because the time is dynamic.
        this.mockMvc.perform(get("/myTime"))
                .andExpect(status().isOk());
    }
}*/
