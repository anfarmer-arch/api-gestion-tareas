package cl.app.ms_taskflow2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Tarea {
    private Long id;
    @NotBlank (message = "La descripción de la tarea no puede estar vacia")
    @Size (message = " La descripción de la Tarea no puede superar los 100 carácteres ")
    private String descripcion;
    @NotNull(message = " El estado de la tarea es obligatorio ")
    private String estado;
    @NotNull(message = " La prioridad de la tarea es obligatoria ")
    private String prioridad;
    @NotBlank (message = " Debe asignar un responsable a la tarea " )
    private String  responsable;
    @NotBlank (message = " Debe ingresar una fecha en formato dd/mm/aaaa ")
    private String fecha_asociada;

}
