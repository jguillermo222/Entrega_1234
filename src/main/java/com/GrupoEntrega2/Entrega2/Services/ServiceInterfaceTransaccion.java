package com.GrupoEntrega2.Entrega2.Services;


import com.GrupoEntrega2.Entrega2.Entities.Transaccion;

import java.util.List;

public interface ServiceInterfaceTransaccion {


    //ver lista

    public List<Transaccion> getTransaccion();

    //traer una transaccion

    public Transaccion getOnlyOneTransaccion(Long idTransaccion) throws Exception;


    //crear una Transaccion

    public String getCreateTransaccion(Transaccion transaccionIn);

    // Actualizar Transaccion

    public Transaccion getUpdateTransaccion(Transaccion transaccionIn)throws Exception;

    //eliminar Transaccion
    public String getDeleteTransaccion(Long idTransaccion) throws Exception;



}
