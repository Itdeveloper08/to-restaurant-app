package com.example.services;

import com.example.dao.ReservacionMesaDao;
import com.example.models.ReservacionMesaModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ReservacionMesaServiceImp implements ReservacionMesaService {

    @Autowired
    private ReservacionMesaDao reservacionMesaDao;

    @Override
    public ReservacionMesaModel saveReservacionMesa(ReservacionMesaModel reservacionMesa) {
        return reservacionMesaDao.save(reservacionMesa);
    }

    @Override
    public void deleteReservacionMesa(Long id) {
        reservacionMesaDao.deleteById(id);
    }

    @Override
    public Optional<ReservacionMesaModel> obtenerPorReservacionYMesa(Long reservacionId, Long mesaId) {
        return reservacionMesaDao.findByReservacionIdAndMesaId(reservacionId, mesaId);
    }
}