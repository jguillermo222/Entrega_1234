package com.GrupoEntrega2.Entrega2.Services;


import com.GrupoEntrega2.Entrega2.Repository.RepositoryPerfilDeEmpleado;


import com.GrupoEntrega2.Entrega2.Entities.PerfilDeEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServicePerfilDeEmpleado implements ServiceInterfacePerfilDeEmpleado {

    //Creacion de atributo (actualizar fecha)

    Date Today = new Date();

    //Ingresar del repositorio a la entity empresa
    @Autowired
    RepositoryPerfilDeEmpleado repositoryPerfilDeEmpleado;

    //1 ya revisado

    @Override
    public List<PerfilDeEmpleado> getPerfilDeEmpleado() { return repositoryPerfilDeEmpleado.findAll();}


    //2 ya revisado
    @Override
    public PerfilDeEmpleado getOnlyOnePerfilDeEmpleado(Long idPerfilDeEmpleado) throws Exception {
        Optional<PerfilDeEmpleado> PerfilDeEmpleadoBD =repositoryPerfilDeEmpleado.findById(idPerfilDeEmpleado);
        if(PerfilDeEmpleadoBD.isPresent()){
            return PerfilDeEmpleadoBD.get();
        }
        throw new Exception("La ceduda del empleado no esta asignada en la base de datos");
    }


     //3 raro
    @Override
    public String getCreatePerfilDeEmpleado(PerfilDeEmpleado PerfilDeEmpleadoIn) {
            //si hay alguna empresa ya esta registrada
            Optional<PerfilDeEmpleado> PerfilDeEmpleadoBD = repositoryPerfilDeEmpleado.findById(PerfilDeEmpleadoIn.getEmpleado().getIdEmpleado());
            if(!PerfilDeEmpleadoBD.isPresent()){
                repositoryPerfilDeEmpleado.save(PerfilDeEmpleadoIn);
                return "Perfil de empleado creado con exito";
            }
            return ("Ese id de Perfil de Empleado ya esta registrado.");
        }




    //4 Falta arreglarlo  imagen teleforno empleado y celular
    @Override
    public PerfilDeEmpleado getUpdatePerfilDeEmpleado(PerfilDeEmpleado perfilEIn) throws Exception {
   return null;
    }


















    //5
    @Override
    public String getDeletePerfilDeEmpleado(Long idPerfilDeEmpleado) throws Exception {
        Optional<PerfilDeEmpleado> PerfilDeEmpleadoBD = repositoryPerfilDeEmpleado.findById(idPerfilDeEmpleado);
        if(PerfilDeEmpleadoBD.isPresent()){
            repositoryPerfilDeEmpleado.deleteById(idPerfilDeEmpleado);
            return "El perfil de empleado ha sido eliminado con exito";

    } throw new Exception("El perfil de empleado no ha sido encontrado");

    }



}
