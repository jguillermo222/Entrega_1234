package com.GrupoEntrega2.Entrega2.controller;

import com.GrupoEntrega2.Entrega2.Entities.Empresa;
import com.GrupoEntrega2.Entrega2.Services.ServiceInterfaceEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class controller {

    @Autowired
    ServiceInterfaceEnterprise serviceInterfaceEnterprise;


    @GetMapping(path = "/pag1")
    public String pag1(Model modelo){

        List<Empresa> listempresas = serviceInterfaceEnterprise.getEnterprise();
        modelo.addAttribute("empresas", listempresas);

        return "pag1";


    }

    }
