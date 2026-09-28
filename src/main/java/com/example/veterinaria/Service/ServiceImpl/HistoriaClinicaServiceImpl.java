package com.example.veterinaria.Service.ServiceImpl;

import com.example.veterinaria.Entity.HistoriaClinica;
import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.Repository.HistoriaClinicaRepository;
import com.example.veterinaria.Service.HistoriaClinicaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    @Override
    public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public List<HistoriaClinica> obtenerHistoriasClinicas() {
        return historiaClinicaRepository.findAll();
    }

    @Override
    public HistoriaClinica obtenerPorId(Long id) {
        return historiaClinicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historia Clínica no encontrada con id: " + id));
    }

    @Override
    public HistoriaClinica actualizarHistoriaClinica(Long id, HistoriaClinica historiaClinica) {
        HistoriaClinica historiaExistente = obtenerPorId(id);

        historiaExistente.setFechaApertura(historiaClinica.getFechaApertura());
        historiaExistente.setAntecedentes(historiaClinica.getAntecedentes());
        historiaExistente.setObservaciones(historiaClinica.getObservaciones());

        return historiaClinicaRepository.save(historiaExistente);
    }

    @Override
    public void eliminarHistoriaClinica(Long id) {
        HistoriaClinica historiaExistente = obtenerPorId(id);
        historiaClinicaRepository.delete(historiaExistente);
    }
}