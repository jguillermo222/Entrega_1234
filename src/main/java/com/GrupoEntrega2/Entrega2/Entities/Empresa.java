package com.GrupoEntrega2.Entrega2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="empresas")
@Data

public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpresa;

    @Column(name = "nombre",unique=true)
    private String nombre;

    @Column (name = "documento", unique=true)
    private String rut;

    @Column(name="telefono")
    private String telefono;

    @Column(name="direccion")
    private String direccion;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY) //3
    private List<Empleado> Empleados;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY) //5
    private List<Transaccion> Transacciones;

    @Column(name="fechaDeCreacion")
    private Date fechaDeCreacion;

    @Column (name="fechaDeActualizacion")
    private Date fechaDeActualizacion;

    public Empresa(String nombre, String rut, String telefono, String direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Empresa(Long idEmpresa, String nombre, String rut, String telefono, String direccion, List<Empleado> empleados, List<Transaccion> transacciones, Date fechaDeCreacion, Date fechaDeActualizacion) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.direccion = direccion;
        Empleados = empleados;
        Transacciones = transacciones;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeActualizacion = fechaDeActualizacion;
    }

    public Empresa() {
    }
}
