package com.example.controllers;

import com.example.services.ReservaMesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservacionMesa")
public class ReservacionMesaController {
    @Autowired
    ReservaMesaService reservaMesaS;    
}
