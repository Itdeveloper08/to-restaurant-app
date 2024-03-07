package com.example.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="RESERVACIONES")
public class ReservacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "PERSONA")
    private String persona;

    @Column(name = "DUI_PERSONA")
    private String duiPersona;

    @Column(name = "FECHA_RESERVACION")
    private Date fechaReservacion;

    @Column(name = "FECHA_RESERVA")
    private String fechaReserva;

    @Column(name = "HORA_RESERVA")
    private String horaReserva;

    @Column(name = "NUM_PERSONAS")
    private Long numPersonas;

    @Column(name = "ACTIVA")
    private boolean activa;
    
    @OneToMany(mappedBy = "reservacion", cascade = CascadeType.ALL)
    @JsonIgnore // Evita la serialización recursiva
    private List<ReservacionMesaModel> mesas = new ArrayList<>();
    
}
