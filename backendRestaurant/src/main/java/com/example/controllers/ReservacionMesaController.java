package com.example.controllers;

import com.example.models.MesaModel;
import com.example.models.ReservacionMesaModel;
import com.example.models.ReservacionModel;
import com.example.services.MesaService;
import com.example.services.ReservacionMesaService;
import com.example.services.ReservacionService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservacionMesa")
public class ReservacionMesaController {
    @Autowired
    ReservacionMesaService reservaMesaS;
    
    @Autowired
    MesaService mesaS;
    
    @Autowired
    ReservacionService reservacionS; 
    
    @GetMapping()
    public ArrayList<ReservacionMesaModel> obtenerReservacionesMesas() {
        return (ArrayList<ReservacionMesaModel>) reservaMesaS.obtenerReservacionMesas();
    }
    @PostMapping
    public ResponseEntity<?> guardarReservacionMesa(@RequestBody ReservacionMesaModel reservacionMesaModel) {
        // Verificar si se proporcionó una mesa en la reservación
        if (reservacionMesaModel.getMesa() == null) {
            return ResponseEntity.badRequest().body("La mesa no se proporcionó correctamente en la reservación.");
        }
        // Si se proporcionó solo el ID de la mesa, buscar el objeto mesa completo
        if (reservacionMesaModel.getMesa().getId() != null) {
            Optional<MesaModel> optionalMesa = mesaS.obtenerPorId(reservacionMesaModel.getMesa().getId());
            if (!optionalMesa.isPresent()) {
                return ResponseEntity.badRequest().body("Mesa no encontrada con el ID proporcionado.");
            }
            reservacionMesaModel.setMesa(optionalMesa.get());
        } else {
            // Si se proporcionó el objeto mesa completo, guardar tal cual
        	reservacionMesaModel.setMesa(mesaS.guardarMesa(reservacionMesaModel.getMesa()));
        }
        // Si se proporcionó solo el ID de la mesa, buscar el objeto mesa completo
        if (reservacionMesaModel.getReservacion().getId() != null) {
            Optional<ReservacionModel> optionalReservacion = reservacionS.obtenerPorId(reservacionMesaModel.getReservacion().getId());
            if (!optionalReservacion.isPresent()) {
                return ResponseEntity.badRequest().body("Reservacion no encontrado con el ID proporcionado.");
            }
            reservacionMesaModel.setReservacion(optionalReservacion.get());
        } else {
            // Si se proporcionó el objeto mesa completo, guardar tal cual
        	reservacionMesaModel.setReservacion(reservacionS.guardarReservacion(reservacionMesaModel.getReservacion()));
        }
        // Guardar la reservación en la base de datos
        ReservacionMesaModel savedReservacionMesa = reservaMesaS.guardarReservacionMesa(reservacionMesaModel);
        return ResponseEntity.ok(savedReservacionMesa);
    }
    
}