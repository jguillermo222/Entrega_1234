package com.GrupoEntrega2.Entrega2.Services;

import com.GrupoEntrega2.Entrega2.Entities.Empresa;

import java.util.List;

public interface ServiceInterfaceEnterprise {
    //ver lista

    public List<Empresa> getEnterprise();

    //traer un enterprise

    public Empresa getOnlyOneEnterprise(Long idEmpresa) throws Exception;

    //crear una empresa

    public String getCreateEnterprise(Empresa empresaIn);

    // Actualizar empresa

    public Empresa getUpdateEnterprise(Empresa empresaIn)throws Exception;

    //eliminar empresa
    public String getDeleteEnterprise(Long idEmpresa) throws Exception;


}
