package com.lucianobrito.pocjavaee8.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
class JacksonConfigTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private JacksonConfig jacksonConfig;


    @Test
    void getContext() {
        var result = jacksonConfig.getContext(this.getClass());

        assertNotNull(result);
    }
}