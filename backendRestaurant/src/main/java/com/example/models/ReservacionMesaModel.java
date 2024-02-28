package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="RESERVACIONES_MESAS")
public class ReservacionMesaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESERVACION_ID", nullable = false)
    private ReservacionModel reservacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MESA_ID")

    private MesaModel mesa;
    
}
