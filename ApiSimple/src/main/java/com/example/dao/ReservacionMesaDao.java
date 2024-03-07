package com.example.dao;

import com.example.models.ReservacionMesaModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionMesaDao extends JpaRepository<ReservacionMesaModel, Long> {

    public Optional<ReservacionMesaModel> findByReservacionIdAndMesaId(Long reservacionId, Long mesaId);
}
