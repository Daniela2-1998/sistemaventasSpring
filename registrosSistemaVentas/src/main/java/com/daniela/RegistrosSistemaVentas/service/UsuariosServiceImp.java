package com.daniela.RegistrosSistemaVentas.service;

import com.daniela.RegistrosSistemaVentas.dto.request.UsuariosRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.UsuariosRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.dto.response.UsuariosResponseDto;
import com.daniela.RegistrosSistemaVentas.exceptions.InsertionDBException;
import com.daniela.RegistrosSistemaVentas.model.Usuarios;
import com.daniela.RegistrosSistemaVentas.repository.IUsuariosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImp implements IUsuariosService{

    // Repositorio
    IUsuariosRepository usuariosRepository;

    // Mapper
    ModelMapper mapper;

    // Constructor
    public UsuariosServiceImp(IUsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
        this.mapper = new ModelMapper();
    }


    // Métodos
    @Override
    public List<UsuariosResponseDto> getAllUsuarios() {
        List<Usuarios> listaUsuarios = usuariosRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        if (listaUsuarios.isEmpty()){
            throw new EntityNotFoundException("No hay usuarios registradas en el sistema.");
        }

        List<UsuariosResponseDto> usuariosResponse = new ArrayList<>();
        listaUsuarios.stream().forEach(usuario -> usuariosResponse.add(mapper.map(usuario, UsuariosResponseDto.class)));

        return usuariosResponse;
    }

    @Override
    public UsuariosResponseDto getUsuarioById(Long id) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isEmpty()){
            throw new EntityNotFoundException("No existe el usuario solicitado con el ID: " + id + ".");
        }

        return mapper.map(usuario, UsuariosResponseDto.class);
    }

    @Override
    public UsuariosResponseDto addUsuario(UsuariosRequestDto usuariosRequestDto) {
        Usuarios usuario = mapper.map(usuariosRequestDto, Usuarios.class);
        Usuarios usuarioPersist = usuariosRepository.save(usuario);

        if(usuarioPersist == null){
            throw new InsertionDBException("No fue posible guardar el usuario " + usuario.getNombreUsuario() + " en la base de datos.");
        }

        return mapper.map(usuarioPersist, UsuariosResponseDto.class);
    }

    @Override
    public UsuariosResponseDto editUsuario(UsuariosRequestConIdDto usuariosRequestConIdDto) {
        UsuariosResponseDto usuarioResponse = getUsuarioById(usuariosRequestConIdDto.getId());
        if(usuarioResponse == null){
            throw new EntityNotFoundException("No fue posible encontrar el usuario solicitado.");
        }

        Usuarios usuario = mapper.map(usuariosRequestConIdDto, Usuarios.class);
        Usuarios usuarioPersist = usuariosRepository.save(usuario);

        if(usuarioPersist == null){
            throw new InsertionDBException("No fue posible guardar la información actualizada del usuario.");
        }

        return mapper.map(usuarioPersist, UsuariosResponseDto.class);
    }

    @Override
    public MensajeRespondeDto deleteUsuario(Long id) {
        usuariosRepository.deleteById(id);
        return new MensajeRespondeDto("Se eliminó correctamente al usuario solicitado.");
    }
}
