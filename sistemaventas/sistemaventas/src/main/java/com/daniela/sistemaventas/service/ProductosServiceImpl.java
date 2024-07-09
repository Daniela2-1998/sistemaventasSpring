package com.daniela.sistemaventas.service;

import com.daniela.sistemaventas.dto.request.ProductosConIdRequestDto;
import com.daniela.sistemaventas.dto.request.ProductosRequestDto;
import com.daniela.sistemaventas.dto.response.MarcasResponseDto;
import com.daniela.sistemaventas.dto.response.MensajeRespondeDto;
import com.daniela.sistemaventas.dto.response.ProductosResponseDto;
import com.daniela.sistemaventas.exceptions.EntityNotFoundException;
import com.daniela.sistemaventas.exceptions.InsertionDBException;
import com.daniela.sistemaventas.model.Categorias;
import com.daniela.sistemaventas.model.Marcas;
import com.daniela.sistemaventas.model.Productos;
import com.daniela.sistemaventas.repository.CategoriasRepository;
import com.daniela.sistemaventas.repository.MarcasRepository;
import com.daniela.sistemaventas.repository.ProductosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements IProductosService {

    // Repositorios
    @Autowired
    ProductosRepository productosRepository;

    @Autowired
    MarcasRepository marcasRepository;

    @Autowired
    CategoriasRepository categoriasRepository;


    // Mapper
    ModelMapper mapper;



    // Constructor
    public ProductosServiceImpl(ProductosRepository productosRepository, MarcasRepository marcasRepository, CategoriasRepository categoriasRepository) {
        this.productosRepository = productosRepository;
        this.marcasRepository = marcasRepository;
        this.categoriasRepository = categoriasRepository;
        mapper = new ModelMapper();
    }


    // Métodos
    @Override
    public List<ProductosResponseDto> getAllProducts() {
        // Retorno de listado de productos.
        List<Productos> listadoProductos = productosRepository.findAll();
        if (listadoProductos.isEmpty()){
            throw new EntityNotFoundException("No hay productos ingresados al sistema.");
        }

        // Transformación del listado de la DB a un response.
        List<ProductosResponseDto> productosResponse = new ArrayList<>();
        listadoProductos.stream().forEach(producto -> productosResponse.add(mapper.map(producto, ProductosResponseDto.class)));

        return productosResponse;
    }

    @Override
    public ProductosResponseDto getProductById(Long id) {
        // Retorno del producto.
        Optional<Productos> producto = productosRepository.findById(id);
        if (producto.isEmpty()){
            throw new EntityNotFoundException("Producto no encontrado con el ID " + id + ".");
        }

        return mapper.map(producto, ProductosResponseDto.class);
    }

    @Override
    public ProductosResponseDto addProduct(ProductosRequestDto productosRequestDto, Long marcaId, Long categoriaId) {
        // Conversión de request a entidad producto.
        Productos producto = mapper.map(productosRequestDto, Productos.class);

        // Recupero y guardado de la marca.
        Marcas marca = marcasRepository.findById(marcaId)
                .orElseThrow(() -> new IllegalArgumentException("No fue posible encontrar la marca solicitada."));
        producto.setMarca(marca);

        // Recupero y guardado de la categoría.
        Categorias categoria = categoriasRepository.findById(categoriaId)
                .orElseThrow(() -> new IllegalArgumentException("No fue posible encontrar la categoría solicitada."));
        producto.setCategoria(categoria);

        // Guardado del producto en DB.
        Productos productoPersist = productosRepository.save(producto);

        if (productoPersist == null){
            throw new InsertionDBException("Error al guardar " + producto.getNombre() + " en la base de datos.");
        }

        return mapper.map(productoPersist, ProductosResponseDto.class);
    }

    @Override
    public ProductosResponseDto editProduct(ProductosConIdRequestDto productosConIdRequestDto) {
        // Obtención del producto por ID y transformación en entidad para su guardado en DB.
        ProductosResponseDto productoResponse = getProductById(productosConIdRequestDto.getId());

        Productos producto = mapper.map(productosConIdRequestDto, Productos.class);
        Productos productoPersist = productosRepository.save(producto);

        return mapper.map(productoPersist, ProductosResponseDto.class);
    }

    @Override
    public MensajeRespondeDto deleteProduct(Long id) {
        getProductById(id);
        productosRepository.deleteById(id);
        return new MensajeRespondeDto("Se eliminó correctamente el producto solicitado.");
    }
}
