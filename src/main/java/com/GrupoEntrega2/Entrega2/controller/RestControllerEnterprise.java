package com.GrupoEntrega2.Entrega2.controller;

import com.GrupoEntrega2.Entrega2.Services.ServiceInterfaceEnterprise;
import com.GrupoEntrega2.Entrega2.Entities.Empresa;
import com.GrupoEntrega2.Entrega2.Entities.Objectanw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEnterprise {

    //Conneccion interfaceenterprise
    @Autowired
    ServiceInterfaceEnterprise serviceInterfaceEnterprise;

    //MAPEO PARA LISTAR EMPRESAS ok
    @GetMapping("/listaEmpresas")
    public ResponseEntity<List<Empresa>> getEmpresa() {
        return new ResponseEntity<>(serviceInterfaceEnterprise.getEnterprise(), HttpStatus.ACCEPTED);
    }

    //MAPEO PARA LISTAR UNA EMPRESA ok
    @GetMapping("/unaEmpresa/{idEmpresa}")
    public ResponseEntity<Object> getEnterprisePath(@PathVariable Long idEmpresa){
        try{
            Empresa EmpresaX = serviceInterfaceEnterprise.getOnlyOneEnterprise(idEmpresa);
            return new ResponseEntity<>(EmpresaX,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //MAPEO PARA CREAR UNA EMPRESA ya

    @PostMapping ("/CreateEnterprise")
    public ResponseEntity<String> PostCreateEnterprise(@RequestBody Empresa EmpresaX){
        try {
            String message =serviceInterfaceEnterprise.getCreateEnterprise(EmpresaX);
            return new ResponseEntity<>(message,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

     //Mapeo para actualizar

    @PutMapping ("/UpdateEnterprise/")
    public ResponseEntity<Objectanw> putUpdateEnterprise(@RequestBody Empresa EmpresaX){
        try{
            Empresa empresaBD =serviceInterfaceEnterprise.getUpdateEnterprise(EmpresaX);
            return  new ResponseEntity<>(new Objectanw("La actualización de la empresa fue existosa", empresaBD), HttpStatus.OK);
    } catch (Exception e) {
            return new ResponseEntity<>(new Objectanw(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapeo para eliminar una e mpresa

    @DeleteMapping("/DeleteEnterprise/{idEmpresa}")
    public ResponseEntity<String> DeleteEnterprise(@PathVariable Long idEmpresa){
        try{
            String message = serviceInterfaceEnterprise.getDeleteEnterprise(idEmpresa);
            return new ResponseEntity<>(message, HttpStatus.OK);
    } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
