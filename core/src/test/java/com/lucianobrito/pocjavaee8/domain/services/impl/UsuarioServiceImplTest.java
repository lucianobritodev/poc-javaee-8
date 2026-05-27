package com.lucianobrito.pocjavaee8.domain.services.impl;

import com.lucianobrito.pocjavaee8.domain.dtos.UsuarioDto;
import com.lucianobrito.pocjavaee8.domain.entities.Usuario;
import com.lucianobrito.pocjavaee8.domain.repositories.UsuarioRepository;
import com.lucianobrito.pocjavaee8.exceptions.errors.BusinessException;
import com.lucianobrito.pocjavaee8.exceptions.errors.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Spy
    private ModelMapper modelMapper;

    private Usuario usuario;


    @BeforeEach
    void setUp() {
        getMocks();
    }

    @Test
    void findAll() {
        when(usuarioRepository.findAll()).thenReturn(Collections.singletonList(new Usuario()));

        List<UsuarioDto> response = usuarioService.findAll();

        assertNotNull(response);
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void findAllThrowBusinessException() {
        when(usuarioRepository.findAll()).thenThrow(new RuntimeException("Erro ao buscar lista de usuarios"));

        assertThrows(BusinessException.class, () -> usuarioService.findAll());

        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));

        UsuarioDto response = usuarioService.findById(1L);

        assertNotNull(response);
        assertEquals(usuario.getId(), response.getId());
        verify(usuarioRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByIdThrowResourceNotFoundException() {
        when(usuarioRepository.findById(anyLong())).thenThrow(new ResourceNotFoundException("Usuario não encontrado!"));

        assertThrows(ResourceNotFoundException.class, () -> usuarioService.findById(1L));

        verify(usuarioRepository, times(1)).findById(anyLong());
    }

    @Test
    void findByIdThrowBusinessException() {
        when(usuarioRepository.findById(anyLong())).thenThrow(new RuntimeException("Erro ao buscar usuario por id"));

        assertThrows(BusinessException.class, () -> usuarioService.findById(1L));

        verify(usuarioRepository, times(1)).findById(anyLong());
    }


    @Test
    void create() {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);

        when(usuarioRepository.create(any(Usuario.class))).thenReturn(usuario);

        UsuarioDto response = usuarioService.create(usuarioDto);

        assertNotNull(response);
        assertNotNull(response.getId());
        verify(usuarioRepository, times(1)).create(any(Usuario.class));
    }

    @Test
    void createThrowBusinessException() {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);

        when(usuarioRepository.create(any(Usuario.class))).thenThrow(new RuntimeException("Erro ao criar usuario"));

        assertThrows(BusinessException.class, () -> usuarioService.create(usuarioDto));

        verify(usuarioRepository, times(1)).create(any(Usuario.class));
    }

    @Test
    void update() {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        usuarioDto.setNome("Alfredo");

        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));
        when(usuarioRepository.update(any(Usuario.class))).thenReturn(new Usuario(usuarioDto));

        UsuarioDto response = usuarioService.update(1L, usuarioDto);

        assertNotNull(response);
        assertEquals("Alfredo", response.getNome());
        verify(usuarioRepository, times(1)).update(any(Usuario.class));
    }

    @Test
    void updateThrowBusinessException() {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        usuarioDto.setNome("Alfredo");

        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));
        when(usuarioRepository.update(any(Usuario.class))).thenThrow(new RuntimeException("Erro ao atualizar usuario"));

        assertThrows(BusinessException.class, () -> usuarioService.update(1L, usuarioDto));

        verify(usuarioRepository, times(1)).update(any(Usuario.class));
    }

    @Test
    void delete() {
        doNothing().when(usuarioRepository).deleteById(anyLong());

        usuarioService.delete(1L);

        verify(usuarioRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteThrowBusinessException() {
        doThrow(new RuntimeException("Erro ao excluir usuário")).when(usuarioRepository).deleteById(anyLong());

        assertThrows(BusinessException.class, () -> usuarioService.delete(1L));

        verify(usuarioRepository, times(1)).deleteById(anyLong());
    }

    private void getMocks() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Luciano");
        usuario.setEmail("test@email.com");
        usuario.setCpf("123.456.789-00");
        usuario.setSenha("123Test");
        usuario.setAtivo(true);
    }
}