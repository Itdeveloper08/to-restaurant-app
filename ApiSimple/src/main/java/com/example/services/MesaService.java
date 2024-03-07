package com.example.services;

import com.example.models.MesaModel;
import java.util.List;
import java.util.Optional;

public interface MesaService {
    Optional<MesaModel> obtenerPorId(Long id);
    List<MesaModel> getAllMesas();
    MesaModel saveMesa(MesaModel mesa);
    void deleteMesa(Long id);
}
