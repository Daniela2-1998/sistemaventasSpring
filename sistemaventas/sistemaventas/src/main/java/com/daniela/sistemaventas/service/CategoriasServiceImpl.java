package com.daniela.sistemaventas.service;

import com.daniela.sistemaventas.dto.request.CategoriasConIdRequestDto;
import com.daniela.sistemaventas.dto.request.CategoriasRequestDto;
import com.daniela.sistemaventas.dto.response.CategoriasResponseDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;
import com.daniela.sistemaventas.exceptions.EntityNotFoundException;
import com.daniela.sistemaventas.exceptions.InsertionDBException;
import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.repository.CategoriasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoriasServiceImpl implements ICategoriasService{

    // Repositorio
    @Autowired
    CategoriasRepository categoriasRepository;

    // Mapper
    ModelMapper mapper;

    // Constructor
    public CategoriasServiceImpl(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
        mapper = new ModelMapper();
    }

    // Métodos
    @Override
    public List<CategoriasResponseDto> getAllCategorias() {
        List<Categorias> listadoCategorias = categoriasRepository.findAll();
        if (listadoCategorias.isEmpty()){
            throw new EntityNotFoundException("No hay categorías registradas en el sistema.");
        }

        List<CategoriasResponseDto> categoriasResponse = new ArrayList<>();
        listadoCategorias.stream().forEach(categoria -> categoriasResponse.add(mapper.map(categoria, CategoriasResponseDto.class)));

        return categoriasResponse;
    }

    @Override
    public CategoriasResponseDto getCategoriaById(Long id) {
        Optional<Categorias> categoria = categoriasRepository.findById(id);
        if (categoria.isEmpty()){
            throw new EntityNotFoundException("No se encontró ninguna categoría con el ID: " + id + ".");
        }

        return mapper.map(categoria, CategoriasResponseDto.class);
    }

    @Override
    public CategoriasResponseDto addCategoria(CategoriasRequestDto categoriaRequestDto) {
        Categorias categoria = mapper.map(categoriaRequestDto, Categorias.class);
        Categorias categoriaPersist = categoriasRepository.save(categoria);

        if (categoriaPersist == null){
            throw new InsertionDBException("No es posible agregar la categoría " + categoriaPersist.getNombre()
                    + " a la base de datos.");
        }

        return mapper.map(categoriaPersist, CategoriasResponseDto.class);
    }

    @Override
    public CategoriasResponseDto editCategoria(CategoriasConIdRequestDto categoriaConIdRequestDto) {
        CategoriasResponseDto categoriaResponse = getCategoriaById(categoriaConIdRequestDto.getId());
        if (categoriaResponse == null){
            throw new EntityNotFoundException("No fue posible encontrar la categoría con el ID " +
                    categoriaConIdRequestDto.getId() + ".");
        }

        Categorias categoria = mapper.map(categoriaConIdRequestDto, Categorias.class);
        Categorias categoriasPersist = categoriasRepository.save(categoria);

        if(categoriasPersist == null){
            throw new InsertionDBException("No fue posible actualizar la categoría " + categoriaConIdRequestDto.getNombre());
        }

        return mapper.map(categoriasPersist, CategoriasResponseDto.class);
    }

    @Override
    public MensajeRespondeDto deleteCategoria(Long id) {
        categoriasRepository.deleteById(id);
        return new MensajeRespondeDto("Se eliminó correctamente la categoría solicitada.");
    }
}
