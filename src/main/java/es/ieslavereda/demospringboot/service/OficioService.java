package es.ieslavereda.demospringboot.service;

import es.ieslavereda.demospringboot.model.Oficio;
import es.ieslavereda.demospringboot.repository.OficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OficioService {

    @Autowired
    private OficioRepository oficioRepository;


    public List<Oficio> getOficios(){
        return oficioRepository.getAll();
    }

    public Oficio getOficioById(Integer id) throws SQLException {
        return oficioRepository.findById(id);
    }

    public Object crearOficio(Oficio oficio) throws SQLException{
        return oficioRepository.insertarOficio(oficio);
    }
}
