package com.api.pasajes.services.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.pasajes.models.Cliente;
import com.api.pasajes.models.Destino;
import com.api.pasajes.models.Pasaje;
import com.api.pasajes.repositorys.PasajeRepository;
import com.api.pasajes.services.PasajeService;

@Service
public class PasajeServiceImpl implements PasajeService {

    @Autowired
    private PasajeRepository pasajeRepository;

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @Autowired
    private DestinoServiceImpl destinoServiceImpl;

    @Autowired
    private EmpresaServiceImpl empresaServiceImpl;

 

    @Override
    @Transactional
    public ResponseEntity<Pasaje> create(Cliente cliente, String formaPago, Float valor, String ciudad,
            String nombreEmpresa) {
        try {
            // Buscar y crear el destino
            ResponseEntity<Destino> destino = destinoServiceImpl.create(ciudad);
            Destino nuevoDestino = destino.getBody();

            // Crear el pasaje
            Pasaje pasaje = new Pasaje(formaPago, valor, nuevoDestino);
            pasajeRepository.save(pasaje);

            // Buscar empresa y agregarle el pasaje
            empresaServiceImpl.addPasaje(nombreEmpresa, pasaje);
            // Crear el cliente nuevo
            clienteServiceImpl.create(cliente);
            clienteServiceImpl.addPasaje(pasaje, cliente);
            return ResponseEntity.ok(pasaje);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return ResponseEntity.badRequest().build();
    }



    @Override
    public List<Pasaje> getAllList() {
        return pasajeRepository.findAll();        
    }



    @Override
    public ResponseEntity<Pasaje> getById(Integer id) {
        Optional<Pasaje> pasaje = pasajeRepository.findById(id);
        return ResponseEntity.ok(pasaje.get());
    }
}
