package com.example.david.sisalima.ExamenPracticoM5A.Controller;

import com.example.david.sisalima.ExamenPracticoM5A.Model.Empleado;
import com.example.david.sisalima.ExamenPracticoM5A.Service.IEmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    IEmpleadoService empleadoService;

    @GetMapping("/buscar/{id}")
    public Empleado buscar(@PathVariable Long id){
        return empleadoService.findById(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> getAll() {
        try {
            return new ResponseEntity<>(empleadoService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarEmpleado(@Valid @RequestBody Empleado empleado){
        try {
        if (empleado.getDias_trabajo()>30){
            empleado.setSueldo((empleado.getDias_trabajo()*15.0)+(empleado.getDias_trabajo()*15)*0.05);
            return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
        }else {
            if (empleado.getDias_trabajo()>=20){
                empleado.setSueldo((empleado.getDias_trabajo()*15.0)+(empleado.getDias_trabajo()*15)*0.02);
                return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
            }
        }
        empleado.setSueldo((empleado.getDias_trabajo()*15.0));
        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
        /*
        try {
            return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
        */
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> EliminarEmpleado(@PathVariable("id") Long id) {
        try {
            empleadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Empleado> updateClient( @Valid @RequestBody Empleado empleado, @PathVariable("id") Long id){
        Empleado canUp = empleadoService.findById(id);

        if(canUp == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                Empleado empleado1=empleadoService.findById(id);
                empleado1.setApellido(empleado.getApellido());
                empleado1.setNombre(empleado.getNombre());
                empleado1.setDireccion(empleado.getDireccion());
                empleado1.setSueldo(empleado.getSueldo());
                empleado1.setDias_trabajo(empleado.getDias_trabajo());
                empleado1.setFecha_nacimiento(empleado.getFecha_nacimiento());
                empleado1.setObservacion(empleado.getObservacion());
                empleado1.setTelefono(empleado.getTelefono());
                return new ResponseEntity<>(empleadoService.save(empleado1), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}
