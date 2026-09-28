package com.example.veterinaria.Controller;

import com.example.veterinaria.Entity.Veterinario;
import com.example.veterinaria.Service.VeterinarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/veterinario")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    // CREAR VETERINARIO
    @PostMapping("/crear")
    public ResponseEntity<Veterinario> crearVeterinario(@Valid @RequestBody Veterinario veterinario) {
        Veterinario veterinarioCreado = veterinarioService.crearVeterinario(veterinario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(veterinarioCreado);
    }

    // LISTAR VETERINARIOS
    @GetMapping("/obtener")
    public ResponseEntity<List<Veterinario>> obtenerVeterinarios() {
        List<Veterinario> veterinarios = veterinarioService.obtenerVeterinarios();

        return ResponseEntity.ok(veterinarios);
    }

    // BUSCAR POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Veterinario> obtenerPorId(@PathVariable Long id) {
        Veterinario veterinario = veterinarioService.obtenerPorId(id);

        return ResponseEntity.ok(veterinario);
    }

    // ELIMINAR VETERINARIO
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVeterinario(@PathVariable Long id) {
        veterinarioService.eliminarVeterinario(id);

        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR VETERINARIO
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Veterinario> actualizarVeterinario(
            @PathVariable Long id,
            @Valid @RequestBody Veterinario veterinario) {

        Veterinario veterinarioActualizado = veterinarioService.actualizarVeterinario(id, veterinario);

        return ResponseEntity.ok(veterinarioActualizado);
    }
}