package com.app.interfaces;

import com.app.models.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ClienteDao {
    
    List<Cliente> getAllClientes();
    Cliente getCliente(int id);
    void addCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    void deleteCliente(int id);
    
}
