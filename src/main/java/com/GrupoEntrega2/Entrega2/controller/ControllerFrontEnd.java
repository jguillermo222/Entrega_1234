package com.GrupoEntrega2.Entrega2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerFrontEnd {

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/pagina2")
    public String pag2(){

        return "pagina2";
    }

}
