package com.example.services;

import com.example.models.ReservacionMesaModel;
import java.util.Optional;

public interface ReservacionMesaService {
    ReservacionMesaModel saveReservacionMesa(ReservacionMesaModel reservacionMesa);
    void deleteReservacionMesa(Long id);
    public Optional<ReservacionMesaModel> obtenerPorReservacionYMesa(Long reservacionId, Long mesaId);
}
