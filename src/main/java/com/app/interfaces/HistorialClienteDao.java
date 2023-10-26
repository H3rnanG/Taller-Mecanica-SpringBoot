package com.app.interfaces;

import com.app.models.HistorialCliente;
import java.util.List;

public interface HistorialClienteDao {

    List<HistorialCliente> getAllHistorialCliente();
    HistorialCliente getHistorialCliente(int id);
    void addCliente(HistorialCliente cliente);
    void updateCliente(HistorialCliente cliente);
    
}
