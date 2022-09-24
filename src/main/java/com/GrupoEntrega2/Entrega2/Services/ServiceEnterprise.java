package com.GrupoEntrega2.Entrega2.Services;

import com.GrupoEntrega2.Entrega2.Repository.RepositoryEnterprise;
import com.GrupoEntrega2.Entrega2.repositorio.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceEnterprise implements ServiceInterfaceEnterprise {

    //Creacion de atributo (actualizar fecha)

    Date Today = new Date();

    //Ingresar del repositorio a la entity empresa
    @Autowired
    RepositoryEnterprise repositoryEnterprise;



    @Override
    public List<Empresa> getEnterprise() {
        return repositoryEnterprise.findAll();
    }

    @Override
    public Empresa getOnlyOneEnterprise(Long idEmpresa) throws Exception {
        Optional<Empresa> EnterpriseBD =repositoryEnterprise.findById(idEmpresa);
        if(EnterpriseBD.isPresent()){
            return EnterpriseBD.get();
        }
        throw new Exception("id Empresa no asignada a ninguna empresa en la base de datos");
    }

    @Override
    public String getCreateEnterprise(Empresa empresaIn) {
        //si hay alguna empresa ya esta registrada
        Optional<Empresa> EnterpriseBD = repositoryEnterprise.findById(empresaIn.getIdEmpresa());
        if(!EnterpriseBD.isPresent()){
            repositoryEnterprise.save(empresaIn);
            return "Empresa creada con exito";
        }
        return ("Ese id de empresa ya esta registrado.");
    }



    @Override
    public Empresa getUpdateEnterprise(Empresa empresaIn) throws Exception {
        //LLamamos a empresa a actualizar en la BD
        Empresa empresaBD = getOnlyOneEnterprise(empresaIn.getIdEmpresa());
        // actualizar atributos
        if (empresaIn.getNombre()!=null && !empresaIn.getNombre().equals("")){
            empresaBD.setNombre(empresaIn.getNombre());
        }
        if (empresaIn.getRut()!=null && !empresaIn.getRut().equals("")){
            empresaBD.setRut(empresaIn.getRut());
        }
        if (empresaIn.getTelefono()!=null && !empresaIn.getTelefono().equals("")){
            empresaBD.setTelefono(empresaIn.getTelefono() );
        }
        if (empresaIn.getDireccion()!=null && !empresaIn.getDireccion().equals("")){
            empresaBD.setDireccion(empresaIn.getDireccion() );
        }
        empresaBD.setFechaDeActualizacion(Today);

        return repositoryEnterprise.save(empresaBD);
    }

    @Override
    public String getDeleteEnterprise(Long idEmpresa) throws Exception {
        Optional<Empresa> empresaBD = repositoryEnterprise.findById(idEmpresa);
       if(empresaBD.isPresent()){
           repositoryEnterprise.deleteById(idEmpresa);
           return "Empresa ha sido eliminada con exito";
       }
        throw new Exception("La empresa no ha sido encontrada");
    }
}
