package com.example.arquitectura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductoRepository repository;

    public DataInitializer(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        System.out.println(">>> Generando 50,000 registros, espera un momento...");
        List<Producto> lista = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            lista.add(new Producto("Producto " + i, Math.random() * 100));
        }
        repository.saveAll(lista);
        System.out.println(">>> ¡Listo! 50,000 registros guardados en la base de datos <<<");
    }
}