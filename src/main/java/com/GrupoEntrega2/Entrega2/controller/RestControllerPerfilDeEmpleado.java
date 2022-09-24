package com.GrupoEntrega2.Entrega2.controller;


import com.GrupoEntrega2.Entrega2.Services.ServiceInterfacePerfilDeEmpleado;
import com.GrupoEntrega2.Entrega2.repositorio.Objectanw;
import com.GrupoEntrega2.Entrega2.repositorio.PerfilDeEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerPerfilDeEmpleado {


    @Autowired
    ServiceInterfacePerfilDeEmpleado serviceInterfacePerfilDeEmpleado;


    //MAPEO PARA LISTAR LOS PERFILES DE LOS EMPLEADOS
    @GetMapping("/listarPerfildeEmpleado")
    public ResponseEntity<List<PerfilDeEmpleado>> getPerfildeEmpleado() {
        return new ResponseEntity<>(serviceInterfacePerfilDeEmpleado.getPerfilDeEmpleado(), HttpStatus.ACCEPTED);
    }


    //MAPEO PARA LISTAR UNA PERFIL DE UN EMPLEADO
    @GetMapping("/unPerfilDeUnEmpleado/{idPerfilDeEmpleado}")
    public ResponseEntity<Object> getPerfilDeEmpleadoPath(@PathVariable Long idPerfilDeEmpleado){
        try{
            PerfilDeEmpleado PerfilDeEmpleadoX = serviceInterfacePerfilDeEmpleado.getOnlyOnePerfilDeEmpleado(idPerfilDeEmpleado);
            return new ResponseEntity<>(PerfilDeEmpleadoX,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //MAPEO PARA CREAR UNA PERFIL DE EMPLEADO

    @PostMapping("/CreatePerfildeEmpleado")
    public ResponseEntity<String> PostCreatePerfildeEmpleado(@RequestBody PerfilDeEmpleado perfilX){
        try {
            String message = serviceInterfacePerfilDeEmpleado.getCreatePerfilDeEmpleado(perfilX);
            return new ResponseEntity<>(message,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Mapeo para actualizar

    @PutMapping ("/UpdatePerfilDeEmpleado")
    public ResponseEntity<Objectanw> putUpdatePerfilDeEmpleado(@RequestBody PerfilDeEmpleado PerfilX){
        try{
            PerfilDeEmpleado PerfilBD =serviceInterfacePerfilDeEmpleado.getUpdatePerfilDeEmpleado(PerfilX);
            return  new ResponseEntity<>(new Objectanw("La actualización de la Perfil del empleado fue existosa", PerfilBD), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Objectanw(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Mapeo para eliminar una empresa

    @DeleteMapping("/DeletePerfilDeEmpleado/{idPerfilDeEmpleado}")
    public ResponseEntity<String> DeletePerdildeEmpleado(@PathVariable Long idPerfilDeEmpleado){
        try{
            String message = serviceInterfacePerfilDeEmpleado.getDeletePerfilDeEmpleado(idPerfilDeEmpleado);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
