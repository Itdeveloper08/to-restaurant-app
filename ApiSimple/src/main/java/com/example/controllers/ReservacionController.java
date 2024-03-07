package com.example.controllers;

import com.example.models.MesaModel;
import com.example.models.ReservacionModel;
import com.example.models.ReservacionMesaModel;
import com.example.services.MesaService;
import com.example.services.ReservacionService;
import com.example.services.ReservacionMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservacion")
public class ReservacionController {

    @Autowired
    private ReservacionService reservacionService;

    @Autowired
    private ReservacionMesaService reservacionMesaService;
    
    @Autowired
    private MesaService mesaService;

    @GetMapping()
    public List<ReservacionModel> obtenerReservaciones() {
        return reservacionService.getAllReservaciones();
    }

    @PostMapping()
    public ReservacionModel guardarReservacion(@RequestBody ReservacionModel reservacion) {
        return reservacionService.saveReservacion(reservacion);
    }

    @PutMapping("/{id}")
    public ReservacionModel actualizarReservacion(@PathVariable Long id, @RequestBody ReservacionModel reservacion) {
        ReservacionModel reservacionExistente = reservacionService.obtenerPorId(id).orElse(null);
        if (reservacionExistente != null) {
            reservacion.setId(id);
            return reservacionService.saveReservacion(reservacion);
        } else {
            // Manejar el caso de que la reservación no exista
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarReservacion(@PathVariable Long id) {
        reservacionService.deleteReservacion(id);
    }

    @PostMapping("/{reservacionId}/mesas/{mesaId}")
    public ReservacionMesaModel agregarMesaAReservacion(@PathVariable Long reservacionId, @PathVariable Long mesaId) {
        ReservacionModel reservacion = reservacionService.obtenerPorId(reservacionId).orElse(null);
        if (reservacion != null) {
            MesaModel mesa = mesaService.obtenerPorId(mesaId).orElse(null);
            if (mesa != null) {
                ReservacionMesaModel reservacionMesa = new ReservacionMesaModel();
                reservacionMesa.setReservacion(reservacion);
                reservacionMesa.setMesa(mesa);
                return reservacionMesaService.saveReservacionMesa(reservacionMesa);
            } else {
                // Manejar el caso de que la mesa no exista
                return null;
            }
        } else {
            // Manejar el caso de que la reservación no exista
            return null;
        }
    }

    @DeleteMapping("/{reservacionId}/mesas/{mesaId}")
    public void eliminarMesaDeReservacion(@PathVariable Long reservacionId, @PathVariable Long mesaId) {
        ReservacionMesaModel reservacionMesa = reservacionMesaService.obtenerPorReservacionYMesa(reservacionId, mesaId).orElse(null);
        if (reservacionMesa != null) {
            reservacionMesaService.deleteReservacionMesa(reservacionMesa.getId());
        }
    }
}
