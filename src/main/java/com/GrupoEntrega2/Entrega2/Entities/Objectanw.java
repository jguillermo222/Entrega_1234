package com.GrupoEntrega2.Entrega2.Entities;

import lombok.Getter;
import lombok.Setter;

public class Objectanw {

    @Setter @Getter
    //Atributos
    private Object object;
    private String message;

    public Objectanw() {
    }

    public Objectanw(String message,Object object) {
        this.object = object;
        this.message = message;
    }
}
