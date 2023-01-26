package com.example.david.sisalima.ExamenPracticoM5A.Service;

import com.example.david.sisalima.ExamenPracticoM5A.Model.Empleado;
import com.example.david.sisalima.ExamenPracticoM5A.Repository.EmpleadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class IEmpleadoServiceImp implements IEmpleadoService{
    @Autowired
    private EmpleadoDao empleadoDao;
    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return empleadoDao.findAll();
    }

    @Override
    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadoDao.save(empleado);
        /*
        if (empleado.getNombre().length() < 15) {
            return empleadoDao.save(empleado);
        }
        else {
            System.out.println("El telefono no debe tener mas de 15 digitos");
            return empleadoDao.save(null);
        }
*/
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        empleadoDao.deleteById(id);
    }
}
