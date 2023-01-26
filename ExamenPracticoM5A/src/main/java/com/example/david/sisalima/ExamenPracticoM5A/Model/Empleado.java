package com.example.david.sisalima.ExamenPracticoM5A.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "empleado")
public class Empleado implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column(name = "id_empleado")
    private Long id_empleado;
    @Column(name = "apellido", length = 45)
    @NotNull(message = "400 bad request")
    private String apellido;
    @Column(name = "nombre",length = 45)
    @NotNull(message = "400 bad request")
    private String nombre;
    @Column(name = "telefono",length = 15)
    @NotNull(message = "400 bad request")
    private String telefono;
    @Column(name = "direccion",length = 45)
    @NotNull(message = "400 bad request")
    private String direccion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;
    @Column(name = "observacion",length = 45)
    @NotNull(message = "400 bad request")
    private String observacion;
    @Column(name = "dias_trabajo")
    @NotNull(message = "400 bad request")
    private Integer dias_trabajo;
    @Column(name = "sueldo")
    @NotNull(message = "400 bad request")
    private Double sueldo;


}
