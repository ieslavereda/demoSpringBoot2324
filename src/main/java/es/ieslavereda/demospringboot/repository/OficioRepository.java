package es.ieslavereda.demospringboot.repository;

import es.ieslavereda.demospringboot.model.Oficio;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Repository
public class OficioRepository {

    private List<Oficio> oficios;

    public OficioRepository() {
        oficios = new ArrayList<>(
                Arrays.asList(
                        new Oficio(1,"Actor"),
                        new Oficio(2,"Banquero")
                )
        );
    }

    public List<Oficio> getAll(){
        return oficios;
    }

    public Oficio findById(Integer id) throws SQLException {

        Optional<Oficio> oficio = oficios.stream()
                .filter(o->o.getId()==id)
                .findFirst();

        if(oficio.isPresent()) return oficio.get();

        throw new SQLException("No existe el oficio con id "+ id);

    }

    public Object insertarOficio(Oficio oficio) throws SQLException {

        Optional<Oficio> optional = oficios.stream()
                .filter(o->o.getId()==oficio.getId())
                .findFirst();
        if(optional.isPresent()) throw new SQLException("Ya existe un oficio con el id "+oficio.getId());
        
        oficios.add(oficio);
        return oficio;

    }
}
