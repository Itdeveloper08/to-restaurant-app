package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MESAS")
public class MesaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int capacidad;
}
