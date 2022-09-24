package com.GrupoEntrega2.Entrega2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerFrontEnd {

    @RequestMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){

        return "index";
    }

    @RequestMapping("/pagina2")
    public String pag2(){

        return "pagina2";
    }

    @RequestMapping("/pagina3")
    public String pag3(){

        return "pagina3";
    }


}
