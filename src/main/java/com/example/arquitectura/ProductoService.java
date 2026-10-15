package com.example.arquitectura;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // Sin caché: siempre va a la base de datos a buscar todos los registros
    public List<Producto> obtenerSinCache() {
        return repository.findAll();
    }

    // Con caché: la primera vez va a la base, las siguientes lo saca directo de la memoria RAM
    @Cacheable("productos")
    public List<Producto> obtenerConCache() {
        return repository.findAll();
    }
}