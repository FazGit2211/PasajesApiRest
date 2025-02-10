package com.api.pasajes.services.serviceImplement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.pasajes.models.Ciudad;
import com.api.pasajes.models.Cliente;
import com.api.pasajes.models.Destino;
import com.api.pasajes.models.Empresa;
import com.api.pasajes.models.Pasaje;
import com.api.pasajes.repositorys.CiudadRepository;
import com.api.pasajes.repositorys.ClienteRepository;
import com.api.pasajes.repositorys.DestinoRepository;
import com.api.pasajes.repositorys.EmpresaRepository;
import com.api.pasajes.repositorys.PasajeRepository;
import com.api.pasajes.services.PasajeService;

@Service
public class PasajeServiceImpl implements PasajeService {

    @Autowired
    private PasajeRepository pasajeRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private DestinoRepository destinoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<Pasaje> create(Cliente cliente, String formaPago, Float valor, String ciudad, String nombreEmpresa) {
        try {
            //Buscar y crear el destino
            Ciudad buscarCiudad = ciudadRepository.findByNombre(ciudad);
            Destino nuevoDestino = new Destino();
            nuevoDestino.setCiudad(buscarCiudad);
            destinoRepository.save(nuevoDestino);
            //Crear el cliente nuevo
            Cliente nuevoCliente = new Cliente(cliente.getNombre(), cliente.getApellido(), cliente.getDni(), cliente.getEmail());
            clienteRepository.save(nuevoCliente);
            //Crear el pasaje
            Pasaje pasaje = new Pasaje(formaPago, valor, nuevoDestino, cliente);
            pasajeRepository.save(pasaje);
            //Buscar empresa y agregarle el pasaje
            Empresa empresa = empresaRepository.findByNombre(nombreEmpresa);
            empresa.addPasajeCollection(pasaje);;
            empresaRepository.save(empresa);
            return ResponseEntity.ok(pasaje);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public List<Pasaje> getPasajes() {
        return pasajeRepository.findAll();
    }
}
