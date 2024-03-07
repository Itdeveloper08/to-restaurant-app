
package com.example.services;

import com.example.dao.ReservacionDao;
import com.example.models.ReservacionModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservacionServiceImp implements ReservacionService {

    private final ReservacionDao reservacionDao;

    @Autowired
    public ReservacionServiceImp(ReservacionDao reservacionDao) {
        this.reservacionDao = reservacionDao;
    }

    @Override
    public List<ReservacionModel> getAllReservaciones() {
        return reservacionDao.findAll();
    }

    @Override
    public ReservacionModel saveReservacion(ReservacionModel reservacion) {
        return reservacionDao.save(reservacion);
    }

    @Override
    public void deleteReservacion(Long id) {
        reservacionDao.deleteById(id);
    }

    @Override
    public Optional<ReservacionModel> obtenerPorId(Long id) {
        return reservacionDao.findById(id);
    }
}
