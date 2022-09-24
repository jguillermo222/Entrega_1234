package com.GrupoEntrega2.Entrega2.controller;


import com.GrupoEntrega2.Entrega2.Services.ServiceInterfaceTransaccion;


import com.GrupoEntrega2.Entrega2.Entities.Objectanw;
import com.GrupoEntrega2.Entrega2.Entities.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerTransaccion {


    //Conneccion interface transaccion
    @Autowired
    ServiceInterfaceTransaccion serviceInterfaceTransaccion;

    //MAPEO PARA LISTAR Transacciones
    @GetMapping("/listarTransacciones")
    public ResponseEntity<List<Transaccion>> getTransaccion1() {
        return new ResponseEntity<>(serviceInterfaceTransaccion.getTransaccion(), HttpStatus.ACCEPTED);
    }

    //MAPEO PARA LISTAR UNA Transaccion
    @GetMapping("/unaTransaccion/{idTransaccion}")
    public ResponseEntity<Object> getTransaccionPath(@PathVariable Long idTransaccion){
        try{
            Transaccion TransaccionX = serviceInterfaceTransaccion.getOnlyOneTransaccion(idTransaccion);
            return new ResponseEntity<>(TransaccionX,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //MAPEO PARA CREAR UNA TRANSACCION

    @PostMapping("/CreateTransaction")
    public ResponseEntity<String> PostCreateTransaction(@RequestBody Transaccion TransaccionX){
        try {
            String message =serviceInterfaceTransaccion.getCreateTransaccion(TransaccionX);
            return new ResponseEntity<>(message,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Mapeo para actualizar

    @PutMapping ("/UpdateTransaction")
    public ResponseEntity<Objectanw> putUpdateTransaction(@RequestBody Transaccion TransaccionX){
        try{
            Transaccion transaccioBD =serviceInterfaceTransaccion.getUpdateTransaccion(TransaccionX);
            return  new ResponseEntity<>(new Objectanw("La actualización de la transacción fue existosa", transaccioBD), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Objectanw(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Mapeo para eliminar una empresa

    @DeleteMapping("/DeleteTransaccion/{idTransaccion}")
    public ResponseEntity<String> DeleteTransaccion(@PathVariable Long idTransaccion){
        try{
            String message = serviceInterfaceTransaccion.getDeleteTransaccion(idTransaccion);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
