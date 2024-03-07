package com.example.models;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESERVACIONES_MESAS")
public class ReservacionMesaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "RESERVACION_ID")
    private ReservacionModel reservacion;
    
    @ManyToOne
    @JoinColumn(name = "MESA_ID")
    private MesaModel mesa;
}
