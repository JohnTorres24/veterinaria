package com.example.veterinaria.Controller;

import com.example.veterinaria.Entity.Mascota;
import com.example.veterinaria.Service.MascotaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mascota")
public class MascotaController {

    private final MascotaService mascotaService;

    // CREAR MASCOTA
    @PostMapping("/crear")
    public ResponseEntity<Mascota> crearMascota(@Valid @RequestBody Mascota mascota) {
        Mascota mascotaCreada = mascotaService.crearMascota(mascota);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mascotaCreada);
    }

    // LISTAR MASCOTAS
    @GetMapping("/obtener")
    public ResponseEntity<List<Mascota>> obtenerMascotas() {
        List<Mascota> mascotas = mascotaService.obtenerMascotas();

        return ResponseEntity.ok(mascotas);
    }

    // LISTAR POR ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long id) {
        Mascota mascota = mascotaService.obtenerPorId(id);

        return ResponseEntity.ok(mascota);
    }

    // ELIMINAR MASCOTA
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);

        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR MASCOTA
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Mascota> actualizarMascota(
            @PathVariable Long id,
            @Valid @RequestBody Mascota mascota) {

        Mascota mascotaActualizada = mascotaService.actualizarMascota(id, mascota);

        return ResponseEntity.ok(mascotaActualizada);
    }

    // BUSCAR MASCOTAS POR PROPIETARIO
    @GetMapping("/propietario/{propietarioId}")
    public ResponseEntity<List<Mascota>> buscarPorPropietario(@PathVariable Long propietarioId) {
        List<Mascota> mascotas = mascotaService.buscarPorPropietario(propietarioId);

        return ResponseEntity.ok(mascotas);
    }

    // ASIGNAR VETERINARIO A MASCOTA
    @PutMapping("/{mascotaId}/asignar-veterinario/{veterinarioId}")
    public ResponseEntity<Mascota> asignarVeterinario(
            @PathVariable Long mascotaId,
            @PathVariable Long veterinarioId) {

        Mascota mascotaActualizada = mascotaService.asignarVeterinario(mascotaId, veterinarioId);

        return ResponseEntity.ok(mascotaActualizada);
    }
}