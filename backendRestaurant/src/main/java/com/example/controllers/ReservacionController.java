package com.example.controllers;

import com.example.dtos.ReservacionDto;
import com.example.models.ReservacionModel;
import com.example.services.ReservacionService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservacion")
public class ReservacionController {

    @Autowired
    ReservacionService reservacionS;

    @GetMapping()
    public List<ReservacionDto> obtenerReservaciones() {
        List<ReservacionModel> mesas = reservacionS.obtenerReservaciones();
        return mesas.stream()
                .map(this::convertirAReservacionDto)
                .collect(Collectors.toList());
    }
   
    @PostMapping()
    public ReservacionModel guardarReservacion(@RequestBody ReservacionModel reservacion) {
        return this.reservacionS.guardarReservacion(reservacion);
    }

    private ReservacionDto convertirAReservacionDto(ReservacionModel reservacion) {
        ReservacionDto reservacionDto = new ReservacionDto();
        reservacionDto.setId(reservacion.getId());
        reservacionDto.setPersona(reservacion.getPersona());
        reservacionDto.setDuiPersona(reservacion.getDuiPersona());
        reservacionDto.setFechaReservacion(reservacion.getFechaReservacion());
        reservacionDto.setFechaReserva(reservacion.getFechaReserva());
        reservacionDto.setHoraReserva(reservacion.getHoraReserva());
        reservacionDto.setNumPersonas(reservacion.getNumPersonas());
        reservacionDto.setReservacionMesa(reservacion.getReservacionMesa());
        reservacionDto.setActiva(reservacion.isActiva());
        return reservacionDto;
    }

}
