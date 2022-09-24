package com.GrupoEntrega2.Entrega2.Services;

import com.GrupoEntrega2.Entrega2.Repository.RepositoryEmpleado;
import com.GrupoEntrega2.Entrega2.Entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceEmpleado implements ServiceInterfaceEmpleado {

    //Creacion de atributo (actualizar fecha)

    Date Today = new Date();

    //Ingresar del repositorio a la entity empresa
    @Autowired
    RepositoryEmpleado repositoryEmpleado;

    //1
    @Override
    public List<Empleado> getEmpleado() {return repositoryEmpleado.findAll();}

    //2
    @Override
    public Empleado getOnlyOneEnterprise(Long idEmpleado) throws Exception {
        Optional<Empleado> EmpleadoBD =repositoryEmpleado.findById(idEmpleado);
        if(EmpleadoBD.isPresent()){
            return EmpleadoBD.get();
        }
        throw new Exception("Id del Empleado no esta asignado a ninguna id en la base de datos");
    }

    //3
    @Override
    public String getCreateEmpleado(Empleado empleadoIn) {
       Optional<Empleado> EmpleadoBD =repositoryEmpleado.findById(empleadoIn.getIdEmpleado());
       if(!EmpleadoBD.isPresent()){
           repositoryEmpleado.save(empleadoIn);
           return "Empleado creado con exito";
       }
       return("Ese id de persona ya esta registrado.");
    }



    //4
    @Override
    public Empleado getUpdateEmpleado(Empleado empleadoIn) throws Exception {
        //Llamamos a empresa a actualizar la BD
        Empleado empleadoBD = getOnlyOneEnterprise(empleadoIn.getIdEmpleado());
        //actualizar atributos
        if(empleadoIn.getEmail()!=null && !empleadoIn.getEmail().equals("")){
            empleadoBD.setEmail(empleadoIn.getEmail());
        }
        //para perfil de empleado
        if(empleadoIn.getPerfilDeEmpleado()!=null && !empleadoIn.getPerfilDeEmpleado().equals("")){
            empleadoBD.setPerfilDeEmpleado(empleadoIn.getPerfilDeEmpleado());
        }
        //para rol
        if(empleadoIn.getRol()!=null && !empleadoIn.getRol().equals("")){
            empleadoBD.setRol(empleadoIn.getRol());
        }
        //para empresa donde trabaja
        if(empleadoIn.getEmpresa()!=null && !empleadoIn.getEmpresa().equals("")){
            empleadoBD.setEmpresa(empleadoIn.getEmpresa());
        }

        return repositoryEmpleado.save(empleadoBD);
    }


    //5
    @Override
    public String getDeleteEmpleado(Long idEmpleado) throws Exception {
        Optional<Empleado> empleadoBD = repositoryEmpleado.findById(idEmpleado);
        if(empleadoBD.isPresent()){
            repositoryEmpleado.deleteById(idEmpleado);
            return "Empleado ha sido eliminada con exito";
        }
        throw new Exception("El empleado no ha sido encontrado");

    }




}
