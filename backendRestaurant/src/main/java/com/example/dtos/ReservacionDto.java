package com.example.dtos;

import com.example.models.ReservacionMesaModel;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class ReservacionDto {
    private Long id;
    private String persona;
    private String duiPersona;
    private Date fechaReservacion;
    private Date fechaReserva;
    private String horaReserva;
    private Long numPersonas;
    private boolean activa;
    private List<ReservacionMesaModel> reservacionMesa;
}
