package cl.app.ms_taskflow2.controller;


import cl.app.ms_taskflow2.model.Tarea;
import cl.app.ms_taskflow2.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {
    @Autowired
    TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<Tarea>> listar() {
        return ResponseEntity.ok(tareaService.listar());
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@Valid @RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.crear(tarea));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtener(@PathVariable long id) {
        return ResponseEntity.ok(tareaService.obtener(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id, @Valid @RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.actualizar(id, tarea));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/estados/{estado}")
    public ResponseEntity<List<Tarea>> buscarPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(tareaService.buscarPorEstado(estado));
    }

}

