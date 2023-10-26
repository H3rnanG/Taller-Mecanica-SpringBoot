package com.app.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity @Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    
    @Column(name = "nombre_razon_social")
    private String nombre_razon_social;
    
    @Column(name = "tipo_documento")
    private String tipo_documento;
    
    @Column(name = "numero_documento")
    private String numero_documento;
    
    @Column(name = "telefono_cliente")
    private String telefono_cliente;
    
    @Column(name = "correo_cliente")
    private String correo_cliente;
    
    @Column(name = "direccion_cliente")
    private String direccion_cliente;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<HistorialCliente> historialesCliente;

    public Cliente() {
    }
    
}
