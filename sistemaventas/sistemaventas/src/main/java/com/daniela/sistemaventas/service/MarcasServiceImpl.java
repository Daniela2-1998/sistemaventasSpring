package com.daniela.sistemaventas.service;

import com.daniela.sistemaventas.dto.request.MarcasConIdRequestDto;
import com.daniela.sistemaventas.dto.request.MarcasRequestDto;
import com.daniela.sistemaventas.dto.response.MarcasResponseDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;
import com.daniela.sistemaventas.dto.response.ProductosResponseDto;
import com.daniela.sistemaventas.exceptions.EntityNotFoundException;
import com.daniela.sistemaventas.exceptions.InsertionDBException;
import com.daniela.sistemaventas.model.Marcas;
import com.daniela.sistemaventas.model.Productos;
import com.daniela.sistemaventas.repository.MarcasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarcasServiceImpl implements IMarcasService{

    // Repositorio
    @Autowired
    MarcasRepository marcasRepository;

    // Mapper
    ModelMapper mapper;

    // Constructor
    public MarcasServiceImpl(MarcasRepository marcasRepository) {
        this.marcasRepository = marcasRepository;
        mapper = new ModelMapper();
    }

    // Métodos
    @Override
    public List<MarcasResponseDto> getAllMarcas() {
        List<Marcas> listadoMarcas = marcasRepository.findAll();
        if(listadoMarcas.isEmpty()){
            throw new EntityNotFoundException("No hay marcas registradas en el sistema");
        }

        List<MarcasResponseDto> marcasResponse = new ArrayList<>();
        listadoMarcas.stream().forEach(marca -> marcasResponse.add(mapper.map(marca, MarcasResponseDto.class)));

        return marcasResponse;
    }

    @Override
    public MarcasResponseDto getMarcaById(Long id) {
        Optional<Marcas> marca = marcasRepository.findById(id);
        if (marca.isEmpty()){
            throw new EntityNotFoundException("No se encontró una marca con el ID: " + id + ".");
        }

        return mapper.map(marca, MarcasResponseDto.class);
    }

    @Override
    public MarcasResponseDto addMarca(MarcasRequestDto marcaRequestDto) {
        Marcas marca = mapper.map(marcaRequestDto, Marcas.class);
        Marcas marcaPersist = marcasRepository.save(marca);

        if (marcaPersist == null){
            throw new InsertionDBException("Error al registrar la marca en la base de datos.");
        }

        return mapper.map(marcaPersist, MarcasResponseDto.class);
    }

    @Override
    public MarcasResponseDto editMarca(MarcasConIdRequestDto marcaConIdRequestDto) {
        MarcasResponseDto marcaResponseDto = getMarcaById(marcaConIdRequestDto.getId());
        if(marcaResponseDto == null){
            throw new EntityNotFoundException("No se encontró una marca con esos datos.");
        }

        Marcas marca = mapper.map(marcaConIdRequestDto, Marcas.class);
        Marcas marcaPersist = marcasRepository.save(marca);

        if (marcaPersist == null){
            throw new InsertionDBException("Error al editar datos de la marca.");
        }

        return mapper.map(marcaPersist, MarcasResponseDto.class);
    }

    @Override
    public MensajeRespondeDto deleteMarca(Long id) {
        marcasRepository.deleteById(id);
        return new MensajeRespondeDto("Se eliminó correctamente la marca solicitada");
    }
}
