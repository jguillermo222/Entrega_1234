package com.GrupoEntrega2.Entrega2.Entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="pruebalibros")
@Data
public class Pruebarepouno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String resumen;
    @Column
    private int capitulos;
    @Column
    private int nroPaginas;
    @Column
    private float calificacion;



}
