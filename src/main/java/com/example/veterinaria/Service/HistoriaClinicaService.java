package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaService {
    HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica);
    List<HistoriaClinica> obtenerHistoriasClinicas();
    HistoriaClinica obtenerPorId(Long id);
    HistoriaClinica actualizarHistoriaClinica(Long id, HistoriaClinica historiaClinica);
    void eliminarHistoriaClinica(Long id);
}