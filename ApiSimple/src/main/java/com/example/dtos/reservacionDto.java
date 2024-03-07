package com.example.dtos;

import java.util.List;
import lombok.Data;

@Data
public class reservacionDto {
    private Long id;
    private String persona;
    private String duiPersona;
    private String fechaReservacion;
    private String fechaReserva;
    private String horaReserva;
    private Long numPersonas;
    private boolean activa;
    private List<MesaDto> mesas;
}
