package com.example.arquitectura;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // <- Esto soluciona CORS para desarrollo
public class BenchmarkController {

    private final ProductoService service;

    public BenchmarkController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/sin-cache")
    public Map<String, Object> testSinCache() {
        long inicio = System.currentTimeMillis();
        int total = service.obtenerSinCache().size();
        long fin = System.currentTimeMillis();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("tipo", "Sin Caché (Base de datos)");
        respuesta.put("tiempoMs", (fin - inicio));
        respuesta.put("totalRegistros", total);
        return respuesta;
    }

    @GetMapping("/con-cache")
    public Map<String, Object> testConCache() {
        long inicio = System.currentTimeMillis();
        int total = service.obtenerConCache().size();
        long fin = System.currentTimeMillis();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("tipo", "Con Caché (Memoria RAM)");
        respuesta.put("tiempoMs", (fin - inicio));
        respuesta.put("totalRegistros", total);
        return respuesta;
    }
}