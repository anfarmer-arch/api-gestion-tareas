package cl.app.ms_taskflow2.repository;


import cl.app.ms_taskflow2.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TareaRepositorio {

    private final Map<Long, Tarea> data = new HashMap<>();

    public List<Tarea> findAll(){
        return new ArrayList<>(data.values());
    }

    public Optional<Tarea> findByID (Long id){
        return  Optional.ofNullable(data.get(id));

    }
     public Tarea save(Tarea tarea){
        data.put(tarea.getId(), tarea);
        return tarea;


     }
     public void  delete(Long id){
        data.remove(id);
     }

}
