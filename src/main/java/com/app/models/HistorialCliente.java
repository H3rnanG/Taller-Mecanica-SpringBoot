package com.app.models;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name = "historial_Cliente")
@Data
public class HistorialCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_cliente")
    private int idHistorialCliente;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "fecha_historial_cliente")
    private Date fechaHistorialCliente;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}