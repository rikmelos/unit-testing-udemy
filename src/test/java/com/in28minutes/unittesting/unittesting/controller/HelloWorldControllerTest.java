package com.in28minutes.unittesting.unittesting.controller;


//import org.junit.jupiter.api.Test;
// Se soluciono el problema quitando las librerias de jupiter api test y solo colocando org.junit.Test
//https://stackoverflow.com/questions/24319697/java-lang-exception-no-runnable-methods-exception-in-running-junits
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest( controllers = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld_basic() throws Exception {

        // Given
        // Real application context
        // When

        //call GET "/hello-world" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        // Then
        // verify "Hello World"
        assertEquals("Hello World", result.getResponse().getContentAsString() );
    }
}