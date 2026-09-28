package com.example.veterinaria.Controller;

import com.example.veterinaria.Entity.Propietario;
import com.example.veterinaria.Service.PropietarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/propietario")
public class PropietarioController {

    private final PropietarioService propietarioService;

    // CREAR PROPIETARIO
    @PostMapping("/crear")
    public ResponseEntity<Propietario> crearPropietario(@Valid @RequestBody Propietario propietario) {
        Propietario propietarioCreado = propietarioService.crearPropietario(propietario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(propietarioCreado);
    }

    // LISTAR PROPIETARIOS
    @GetMapping("/obtener")
    public ResponseEntity<List<Propietario>> obtenerPropietarios() {
        List<Propietario> propietarios = propietarioService.obtenerPropietarios();

        return ResponseEntity.ok(propietarios);
    }

    // LISTAR POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Propietario> obtenerPorId(@PathVariable Long id) {
        Propietario propietario = propietarioService.obtenerPorId(id);

        return ResponseEntity.ok(propietario);
    }

    // ELIMINAR PROPIETARIO
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPropietario(@PathVariable Long id) {
        propietarioService.eliminarPropietario(id);

        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR PROPIETARIO
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Propietario> actualizarPropietario(
            @PathVariable Long id,
            @Valid @RequestBody Propietario propietario) {

        Propietario propietarioActualizado = propietarioService.actualizarPropietario(id, propietario);

        return ResponseEntity.ok(propietarioActualizado);
    }
}