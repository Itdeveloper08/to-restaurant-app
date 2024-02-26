package com.example.dao;

import com.example.models.ReservacionModel;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionDao extends JpaRepository<ReservacionModel, Long>{
    public abstract ArrayList<ReservacionModel> findByPersona(String persona);
    public abstract ArrayList<ReservacionModel> findByDuiPersona(String duiPersona);
    public abstract ArrayList<ReservacionModel> findByFechaReserva(Date fechaReserva);
}
