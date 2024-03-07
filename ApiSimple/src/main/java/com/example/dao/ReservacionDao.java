package com.example.dao;

import com.example.models.ReservacionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservacionDao extends JpaRepository<ReservacionModel,Long>{}