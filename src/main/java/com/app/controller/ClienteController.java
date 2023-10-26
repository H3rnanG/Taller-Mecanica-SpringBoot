package com.app.controller;

import com.app.interfaces.ClienteDao;
import com.app.models.Cliente;
import com.app.services.JsonResponseComponent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private JsonResponseComponent jsonResponseComponent;
    
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteDao.getAllClientes();
    }
    
    @GetMapping("/")
    public Cliente getCliente(@RequestParam("id") int id){
        return clienteDao.getCliente(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<JsonNode> addCliente(@RequestBody Cliente cliente) {
        jsonResponseComponent.clearJsonResponse();
        try {
            clienteDao.addCliente(cliente);
            jsonResponseComponent.addProperty("message", "Cliente Creado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
    @PutMapping("/")
    public ResponseEntity<JsonNode> updateCliente(@RequestParam("id") int id, @RequestBody Cliente cliente) {
        jsonResponseComponent.clearJsonResponse();
        try {
            cliente.setId_cliente(id);
            clienteDao.updateCliente(cliente);
            jsonResponseComponent.addProperty("message", "Cliente Actualizado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
    @DeleteMapping("/")
    public ResponseEntity<JsonNode> deleteCliente(@RequestParam("id") int id) {
        jsonResponseComponent.clearJsonResponse();
        try {
            clienteDao.deleteCliente(id);
            jsonResponseComponent.addProperty("message", "Cliente Eliminado Correctamente.");
        } catch (Exception e) {
            jsonResponseComponent.addProperty("message", e.getMessage());
        }
        return ResponseEntity.ok(jsonResponseComponent.getJsonResponse());
    }
    
    @GetMapping("/crearJson")
    public ResponseEntity<JsonNode> crearJson() {
        // Crear un objeto JSON usando Jackson ObjectNode
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.createObjectNode()
            .put("nombre", "Ejemplo")
            .put("edad", 30);

        // Devolver el JSON usando ResponseEntity
        return ResponseEntity.ok(json);
    }
}
