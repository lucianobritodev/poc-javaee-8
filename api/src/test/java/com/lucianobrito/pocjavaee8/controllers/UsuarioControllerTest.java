package com.lucianobrito.pocjavaee8.controllers;

import com.lucianobrito.pocjavaee8.domain.dtos.UsuarioDto;
import com.lucianobrito.pocjavaee8.domain.services.UsuarioService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @Test
    void findAll() {
        when(usuarioService.findAll()).thenReturn(Collections.emptyList());

        Response response = usuarioController.findAll();

        assertEquals(HttpStatus.SC_OK, response.getStatus());
        assertNotNull(response.getEntity());
        verify(usuarioService, times(1)).findAll();
    }

    @Test
    void findById() {
        when(usuarioService.findById(1L)).thenReturn(new UsuarioDto());

        Response response = usuarioController.findById(1L);

        assertEquals(HttpStatus.SC_OK, response.getStatus());
        assertNotNull(response.getEntity());
        verify(usuarioService, times(1)).findById(1L);
    }

    @Test
    void create() {
        when(usuarioService.create(any(UsuarioDto.class))).thenReturn(new UsuarioDto());

        Response response = usuarioController.create(new UsuarioDto());

        assertEquals(HttpStatus.SC_OK, response.getStatus());
        assertNotNull(response.getEntity());
        verify(usuarioService, times(1)).create(any(UsuarioDto.class));
    }

    @Test
    void update() {
        when(usuarioService.update(anyLong(), any(UsuarioDto.class))).thenReturn(new UsuarioDto());

        Response response = usuarioController.update(1L, new UsuarioDto());

        assertEquals(HttpStatus.SC_OK, response.getStatus());
        assertNotNull(response.getEntity());
        verify(usuarioService, times(1)).update(anyLong(), any(UsuarioDto.class));
    }

    @Test
    void delete() {
        doNothing().when(usuarioService).delete(anyLong());

        usuarioController.delete(1L);

        verify(usuarioService, times(1)).delete(anyLong());
    }
}