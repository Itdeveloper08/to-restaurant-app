package com.example.controllers;

import com.example.dtos.MesaDto;
import com.example.models.MesaModel;
import com.example.services.MesaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesas")
public class MesaController {
    @Autowired
    MesaService mesaS;
    
    @GetMapping()
    public List<MesaDto> obtenerMesas() {
        List<MesaModel> mesas = mesaS.obtenerMesas();
        return mesas.stream()
                .map(this::convertirAMesaDto)
                .collect(Collectors.toList());
    }
    
    private MesaDto convertirAMesaDto(MesaModel mesa) {
        MesaDto mesaDto = new MesaDto();
        mesaDto.setNumero(mesa.getId());
        mesaDto.setCapacidad(mesa.getCapacidad());
        return mesaDto;
    }
}
