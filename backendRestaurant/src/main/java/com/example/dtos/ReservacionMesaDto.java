package com.example.dtos;

import com.example.models.MesaModel;
import lombok.Data;

@Data
public class ReservacionMesaDto {
    private Long id;
    private MesaModel mesa;
}
