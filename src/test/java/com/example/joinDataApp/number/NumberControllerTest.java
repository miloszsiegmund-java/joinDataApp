package com.example.joinDataApp.number;

import com.example.joinDataApp.number.exeptions.CustomExceptionHandler;
import com.example.joinDataApp.strategy.IJoinDataStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IJoinDataStrategy<Integer> IJoinDataStrategy;

    private static final String EXCEPTION_MESSAGE = "Value must not be null";
    private static final String API_URL = "/api/number/join/sum/api/random";

    @Test
    void contextLoads() {
    }

    @Test
    public void shouldReturnNumber() throws Exception {
        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception exception = assertThrows(CustomExceptionHandler.class, () -> {
            IJoinDataStrategy.joinData(null, null);
        });

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(EXCEPTION_MESSAGE));
    }

}
