package com.GrupoEntrega2.Entrega2.Services;

import com.GrupoEntrega2.Entrega2.Entities.Empleado;

import java.util.List;

public interface ServiceInterfaceEmpleado {

    //ver lista

    public List<Empleado> getEmpleado();

    //traer un empleado

    public Empleado getOnlyOneEnterprise(Long idEmpleado) throws Exception;

    //crear un empleado

    public String getCreateEmpleado(Empleado empleadoIn);

    // actualizar empleado

    public Empleado getUpdateEmpleado(Empleado empleadoIn)throws Exception;

    //eliminar empleado
    public String getDeleteEmpleado(Long idEmpleado) throws Exception;

}
