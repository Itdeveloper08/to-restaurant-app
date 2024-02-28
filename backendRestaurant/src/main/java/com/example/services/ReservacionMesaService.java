package com.example.services;

import com.example.models.ReservacionMesaModel;
import java.util.ArrayList;
import java.util.Optional;

public interface ReservacionMesaService{
	public ArrayList<ReservacionMesaModel> obtenerReservacionMesas();
	public ReservacionMesaModel guardarReservacionMesa(ReservacionMesaModel ReservacionMesaM);
	public Optional<ReservacionMesaModel> obtenerPorId(Long id);
	public boolean eliminarReservacionMesa(Long id);
}