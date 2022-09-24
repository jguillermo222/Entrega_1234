package com.GrupoEntrega2.Entrega2.Services;



import com.GrupoEntrega2.Entrega2.Repository.ReposityTransaction;

import com.GrupoEntrega2.Entrega2.repositorio.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceTransaccion implements ServiceInterfaceTransaccion {

    //Creacion de atributo (actualizar fecha)

    Date Today = new Date();

    //Ingresar del repositorio a la entity empresa
    @Autowired
    ReposityTransaction repositoryTransaction;


    //impementacion de metodos


    //1
    @Override
    public List<Transaccion> getTransaccion() { return repositoryTransaction.findAll(); }

    //2

    @Override
    public Transaccion getOnlyOneTransaccion(Long idTransaccion) throws Exception {
        Optional<Transaccion> TransaccioBD =repositoryTransaction.findById(idTransaccion);
        if(TransaccioBD.isPresent()){
            return TransaccioBD.get();
     }

        throw new Exception("id transaccion no asignada a ninguna transaccion en la base de datos");
    }

    //3
    @Override
    public String getCreateTransaccion(Transaccion transaccionIn) {
        Optional<Transaccion> TransaccionBD =repositoryTransaction.findById(transaccionIn.getIdTransaccion());
        if(!TransaccionBD.isPresent()){
            repositoryTransaction.save(transaccionIn);
            return "Transaccion creada con exito";
        }
        return ("Esa transaccion ya esta registrada.");
    }



    //4
    @Override
    public Transaccion getUpdateTransaccion(Transaccion transaccionIn) throws Exception {
        //LLamamos a empresa a actualizar en la BD
        Transaccion transaccionBD = getOnlyOneTransaccion(transaccionIn.getIdTransaccion());
        // actualizar atributos
        if (transaccionIn.getConcepto()!=null && !transaccionIn.getConcepto().equals("")){
            transaccionBD.setConcepto(transaccionIn.getConcepto());
        }
        if (transaccionIn.getMonto()!=0 || transaccionIn.getMonto()==0){
            transaccionBD.setMonto(transaccionIn.getMonto());
        }
        transaccionBD.setFechaDeActualizacion(Today);

        return repositoryTransaction.save(transaccionBD);
    }



    //5
    @Override
    public String getDeleteTransaccion(Long idTransaccion) throws Exception {
        Optional<Transaccion> transaccionBD = repositoryTransaction.findById(idTransaccion);
        if(transaccionBD.isPresent()){
            repositoryTransaction.deleteById(idTransaccion);
            return "Transaccion a sido eliminada con exito";
         }
        throw new Exception("La transacción no ha sido encontrada");

    }

}
