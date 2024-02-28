package com.example.controllers;

import com.example.models.MesaModel;
import com.example.services.MesaService;
import java.util.ArrayList;
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
    public ArrayList<MesaModel> obtenerMesas() {
        return (ArrayList<MesaModel>) mesaS.obtenerMesas();
    }
}
