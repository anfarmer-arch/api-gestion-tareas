package cl.app.ms_taskflow2.service;

import cl.app.ms_taskflow2.model.Tarea;
import cl.app.ms_taskflow2.repository.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    TareaRepositorio tareaRepositorio;

    public List<Tarea> listar() {
        return tareaRepositorio.findAll();
    }

    public Tarea crear(Tarea tarea) {
        return tareaRepositorio.save(tarea);
    }

    public Tarea obtener(Long id) {
        return tareaRepositorio.findByID(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));


    }


    public Tarea actualizar(Long id, Tarea tarea) {
        Tarea existente = obtener(id);
        existente.setDescripcion(tarea.getDescripcion());
        existente.setEstado(tarea.getEstado());
        existente.setPrioridad(tarea.getPrioridad());
        existente.setResponsable(tarea.getResponsable());
        existente.setFecha_asociada(tarea.getFecha_asociada());
        return tareaRepositorio.save(existente);

    }
    public void eliminar(Long id){
        obtener(id);
        tareaRepositorio.delete(id);
    }
    public List<Tarea> buscarPorEstado(String estado){
        return tareaRepositorio.findAll().stream()
                .filter(t -> t.getEstado().equalsIgnoreCase(estado)). toList();



    }
}






