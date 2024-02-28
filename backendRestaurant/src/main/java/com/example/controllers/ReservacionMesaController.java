package com.example.controllers;

import com.example.models.ReservacionMesaModel;
import com.example.services.ReservacionMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservacionMesa")
public class ReservacionMesaController {
    @Autowired
    ReservacionMesaService reservaMesaS;
    
    @PostMapping
    public ResponseEntity<?> guardarReservacionMesa(@RequestBody ReservacionMesaModel reservacionMesaModel) {
        try {
            ReservacionMesaModel savedReservacionMesa = reservaMesaS.guardarReservacionMesa(reservacionMesaModel);
            if(savedReservacionMesa!=null)
            return ResponseEntity.ok("Accion realizada con exito");
            else return ResponseEntity.badRequest().body("Ocurrio un error al realizar la insercion");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}