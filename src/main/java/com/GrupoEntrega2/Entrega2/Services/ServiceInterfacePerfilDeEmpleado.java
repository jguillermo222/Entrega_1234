package com.GrupoEntrega2.Entrega2.Services;

import com.GrupoEntrega2.Entrega2.Entities.PerfilDeEmpleado;

import java.util.List;

public interface ServiceInterfacePerfilDeEmpleado {


    //ver lista

    public List<PerfilDeEmpleado> getPerfilDeEmpleado();

    //traer un p. Empleado

    public PerfilDeEmpleado getOnlyOnePerfilDeEmpleado(Long idPerfilDeEmpleado) throws Exception;

    //crear un p. Empleado


    public String getCreatePerfilDeEmpleado(PerfilDeEmpleado perfilDeEmpleadoIn);

    // actualizar p. Empleado

    public PerfilDeEmpleado getUpdatePerfilDeEmpleado(PerfilDeEmpleado perfilDeEmpleadoIn)throws Exception;

    //eliminar empleado
    public String getDeletePerfilDeEmpleado(Long idPerfilDeEmpleado) throws Exception;




}
