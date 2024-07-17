package com.daniela.RegistrosSistemaVentas.service;

import com.daniela.RegistrosSistemaVentas.dto.request.EmpleadosRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.EmpleadosRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.EmpleadosResponseDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.exceptions.InsertionDBException;
import com.daniela.RegistrosSistemaVentas.model.Empleados;
import com.daniela.RegistrosSistemaVentas.repository.IEmpleadosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosServiceImp implements IEmpleadosService{

    @Autowired
    IEmpleadosRepository empleadosRepository;

    ModelMapper mapper;

    // Constructor
    public EmpleadosServiceImp(IEmpleadosRepository empleadosRepository) {
        this.empleadosRepository = empleadosRepository;
        this.mapper = new ModelMapper();
    }


    // Métodos
    @Override
    public Page<EmpleadosResponseDto> getAllEmpleados(int page, int size, String sortBy){
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Empleados> empleadosPage = empleadosRepository.findAll(pageable);

        if (empleadosPage.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron empleados registrados en el sistema.");
        }

        return empleadosPage.map(empleado -> mapper.map(empleado, EmpleadosResponseDto.class));
    }

    @Override
    public EmpleadosResponseDto getEmpleadoById(Long id) {
        Optional<Empleados> empleado = empleadosRepository.findById(id);
        if(empleado.isEmpty()){
            throw new EntityNotFoundException("No se encontró un empleado con el ID: " + id + ".");
        }

        return mapper.map(empleado, EmpleadosResponseDto.class);
    }

    @Override
    public EmpleadosResponseDto addEmpleado(EmpleadosRequestDto empleadosRequestDto) {
        Empleados empleado = mapper.map(empleadosRequestDto, Empleados.class);
        Empleados empleadoPersist = empleadosRepository.save(empleado);
        if(empleadoPersist == null){
            throw new InsertionDBException("No se pudo guardar en la base de datos al empleado " + empleadoPersist.getNombreCompleto());
        }

        return mapper.map(empleadoPersist, EmpleadosResponseDto.class);
    }

    @Override
    public EmpleadosResponseDto editEmpleado(EmpleadosRequestConIdDto empleadosRequestConIdDto) {
        EmpleadosResponseDto empleadoResponse = getEmpleadoById(empleadosRequestConIdDto.getId());
        if (empleadoResponse == null){
            throw new EntityNotFoundException("No se encontró un empleado con el ID: " + empleadosRequestConIdDto.getId() + ".");
        }

        Empleados empleado = mapper.map(empleadosRequestConIdDto, Empleados.class);
        Empleados empleadoPersist = empleadosRepository.save(empleado);
        if(empleadoPersist == null){
            throw new InsertionDBException("No fue posible guardar al empleado " + empleado.getNombreCompleto() + " - " + empleado.getCargo() +
                    " en la base de datos.");
        }
        return mapper.map(empleadoPersist, EmpleadosResponseDto.class);
    }

    @Override
    public MensajeRespondeDto deleteEmpleado(Long id) {
        empleadosRepository.deleteById(id);
        return new MensajeRespondeDto("Se eliminó correctamente al empleado solicitado.");
    }
}
