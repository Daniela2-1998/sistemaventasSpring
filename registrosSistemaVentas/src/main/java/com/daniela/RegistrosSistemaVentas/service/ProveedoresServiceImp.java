package com.daniela.RegistrosSistemaVentas.service;

import com.daniela.RegistrosSistemaVentas.dto.request.ProveedoresRequestConIdDto;
import com.daniela.RegistrosSistemaVentas.dto.request.ProveedoresRequestDto;
import com.daniela.RegistrosSistemaVentas.dto.response.MensajeRespondeDto;
import com.daniela.RegistrosSistemaVentas.dto.response.ProveedoresResponseDto;
import com.daniela.RegistrosSistemaVentas.exceptions.InsertionDBException;
import com.daniela.RegistrosSistemaVentas.model.Proveedores;
import com.daniela.RegistrosSistemaVentas.repository.IProveedoresRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresServiceImp implements IProveedoresService{

    @Autowired
    IProveedoresRepository proveedoresRepository;

    ModelMapper mapper;


    // Constructor
    public ProveedoresServiceImp(IProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
        this.mapper = new ModelMapper();
    }



    // Métodos
    @Override
    public List<ProveedoresResponseDto> getAllProveedores() {
        List<Proveedores> listaProveedores = proveedoresRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        if(listaProveedores.isEmpty()){
            throw new EntityNotFoundException("No se encontraron proveedores en la base de datos.");
        }

        List<ProveedoresResponseDto> proveedoresResponse = new ArrayList<>();
        listaProveedores.stream().forEach(proveedor -> proveedoresResponse.add(mapper.map(proveedor, ProveedoresResponseDto.class)));

        return proveedoresResponse;
    }

    @Override
    public ProveedoresResponseDto getProveedorById(Long id) {
        Optional<Proveedores> proveedor = proveedoresRepository.findById(id);
        if(proveedor.isEmpty()){
            throw new EntityNotFoundException("No se encontró ningún proveedor con el ID: " + id + ".");
        }

        return mapper.map(proveedor, ProveedoresResponseDto.class);
    }

    @Override
    public ProveedoresResponseDto addProveedor(ProveedoresRequestDto proveedoresRequestDto) {
        Proveedores proveedor = mapper.map(proveedoresRequestDto, Proveedores.class);
        Proveedores proveedorPersist = proveedoresRepository.save(proveedor);

        if(proveedorPersist == null){
            throw new InsertionDBException("No se pudo guardar al proveedor " + proveedor.getEmpresa() +
                    " en la base de datos.");
        }

        return mapper.map(proveedorPersist, ProveedoresResponseDto.class);
    }

    @Override
    public ProveedoresResponseDto editProveedor(ProveedoresRequestConIdDto proveedoresRequestConIdDto) {
        ProveedoresResponseDto proveedorResponse = getProveedorById(proveedoresRequestConIdDto.getId());
        if (proveedorResponse == null){
            throw new EntityNotFoundException("No hay proveedores con el ID " + proveedoresRequestConIdDto.getId());
        }

        Proveedores proveedor = mapper.map(proveedoresRequestConIdDto, Proveedores.class);
        Proveedores proveedorPersist = proveedoresRepository.save(proveedor);
        if (proveedorPersist == null){
            throw new InsertionDBException("No se pudo guardar al proveedor " + proveedor.getEmpresa()
                    + " en la base de datos.");
        }

        return mapper.map(proveedorPersist, ProveedoresResponseDto.class);
    }

    @Override
    public MensajeRespondeDto deleteProveedor(Long id) {
        proveedoresRepository.deleteById(id);
        return new MensajeRespondeDto("Se eliminó al proveedor solicitado.");
    }
}
