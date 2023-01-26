package com.example.david.sisalima.ExamenPracticoM5A.Service;

import com.example.david.sisalima.ExamenPracticoM5A.Model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> findAll();
    public Empleado save(Empleado empleado);
    public Empleado findById(Long id);
    public void delete(Long id);
}
