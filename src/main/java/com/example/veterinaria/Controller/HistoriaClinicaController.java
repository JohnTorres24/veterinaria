package com.example.veterinaria.Controller;

import com.example.veterinaria.Entity.HistoriaClinica;
import com.example.veterinaria.Service.HistoriaClinicaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/historiaclinica")
public class HistoriaClinicaController {

    private final HistoriaClinicaService historiaClinicaService;

    // CREAR HISTORIA CLINICA
    @PostMapping("/crear")
    public ResponseEntity<HistoriaClinica> crearHistoriaClinica(@Valid @RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica historiaCreada = historiaClinicaService.crearHistoriaClinica(historiaClinica);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(historiaCreada);
    }

    // LISTAR HISTORIAS CLINICAS
    @GetMapping("/obtener")
    public ResponseEntity<List<HistoriaClinica>> obtenerHistoriasClinicas() {
        List<HistoriaClinica> historias = historiaClinicaService.obtenerHistoriasClinicas();

        return ResponseEntity.ok(historias);
    }

    // LISTAR POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<HistoriaClinica> obtenerPorId(@PathVariable Long id) {
        HistoriaClinica historia = historiaClinicaService.obtenerPorId(id);

        return ResponseEntity.ok(historia);
    }

    // ELIMINAR HISTORIA CLINICA
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarHistoriaClinica(@PathVariable Long id) {
        historiaClinicaService.eliminarHistoriaClinica(id);

        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR HISTORIA CLINICA
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HistoriaClinica> actualizarHistoriaClinica(
            @PathVariable Long id,
            @Valid @RequestBody HistoriaClinica historiaClinica) {

        HistoriaClinica historiaActualizada = historiaClinicaService.actualizarHistoriaClinica(id, historiaClinica);

        return ResponseEntity.ok(historiaActualizada);
    }
}