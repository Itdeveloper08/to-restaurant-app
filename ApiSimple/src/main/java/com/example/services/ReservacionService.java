package com.example.services;

import com.example.models.ReservacionModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface ReservacionService {
    List<ReservacionModel> getAllReservaciones();
    ReservacionModel saveReservacion(ReservacionModel reservacion);
    void deleteReservacion(Long id);
    Optional<ReservacionModel> obtenerPorId(Long id);
}
