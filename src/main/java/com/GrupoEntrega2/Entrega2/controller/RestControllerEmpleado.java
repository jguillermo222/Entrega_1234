package com.GrupoEntrega2.Entrega2.controller;

import com.GrupoEntrega2.Entrega2.Services.ServiceInterfaceEmpleado;
import com.GrupoEntrega2.Entrega2.repositorio.Empleado;
import com.GrupoEntrega2.Entrega2.repositorio.Objectanw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEmpleado {

    //Conneccion interface empleado

    @Autowired
    ServiceInterfaceEmpleado serviceInterfaceEmpleado;

    //MAPEO PARA Listar Empleado
    @GetMapping("/listaEmpleados")
    public ResponseEntity<List<Empleado>> getEmpleado() {
        return new ResponseEntity<>(serviceInterfaceEmpleado.getEmpleado(), HttpStatus.ACCEPTED);
    }

    //MAPEO PARA LISTAR UNA empleado
    @GetMapping("/unEmpleado/{idEmpleado}")
    public ResponseEntity<Object> getEmpleadoPath(@PathVariable Long idEmpleado){
        try{
            Empleado EmpleadoX = serviceInterfaceEmpleado.getOnlyOneEnterprise(idEmpleado);
            return new ResponseEntity<>(EmpleadoX,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //MAPEO PARA CREAR UNA Empleado

    @PostMapping("/CreateEmpleado")
    public ResponseEntity<String> PostCreateEmpleado(@RequestBody Empleado EmpleadoX){
        try {
            String message =serviceInterfaceEmpleado.getCreateEmpleado(EmpleadoX);
            return new ResponseEntity<>(message,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapeo para actualizar

    @PutMapping ("/UpdateEmpleado")
    public ResponseEntity<Objectanw> putUpdateEmpleado(@RequestBody Empleado EmpleadoX){
        try{
            Empleado empleadoBD =serviceInterfaceEmpleado.getUpdateEmpleado(EmpleadoX);
            return  new ResponseEntity<>(new Objectanw("La actualización del empleado fue existosa", empleadoBD), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Objectanw(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeleteEmpleado/{idEmpleado}")
    public ResponseEntity<String> DeleteEmpleado(@PathVariable Long idEmpleado){
        try{
            String message = serviceInterfaceEmpleado.getDeleteEmpleado(idEmpleado);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
