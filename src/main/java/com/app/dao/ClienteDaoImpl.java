package com.app.dao;

import com.app.interfaces.ClienteDao;
import com.app.models.Cliente;
import com.app.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteDaoImpl implements ClienteDao{
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }
    
}
