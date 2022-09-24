package com.GrupoEntrega2.Entrega2.repositorio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="empleados")
@Data
public class Empleado {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEmpleado;

    @Column(name="email", unique = true)
    private String email;

    //conector
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(mappedBy="empleado")
    private PerfilDeEmpleado PerfilDeEmpleado;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Enum_rol.class,fetch = FetchType.EAGER)
    @Column(name="rol")
    private List<Enum_rol> rol;

    //connectores

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "empresa_id")  //3
    private Empresa empresa;

    //connectores
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY) //4
    private List<Transaccion> Transacciones;


    @Column(name="fechaDeCreacion")
    private Date fechaDeCreacion;

    @Column(name="fechaDeActualizacion")
    private Date fechaDeActualizacion;

    public Empleado(String email, com.GrupoEntrega2.Entrega2.repositorio.PerfilDeEmpleado perfilDeEmpleado, List<Enum_rol> rol, Empresa empresa) {
        this.email = email;
        PerfilDeEmpleado = perfilDeEmpleado;
        this.rol = rol;
        this.empresa = empresa;
    }


    public Empleado(long idEmpleado, String email, com.GrupoEntrega2.Entrega2.repositorio.PerfilDeEmpleado perfilDeEmpleado, List<Enum_rol> rol, Empresa empresa, List<Transaccion> transacciones, Date fechaDeCreacion, Date fechaDeActualizacion) {
        this.idEmpleado = idEmpleado;
        this.email = email;
        PerfilDeEmpleado = perfilDeEmpleado;
        this.rol = rol;
        this.empresa = empresa;
        Transacciones = transacciones;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeActualizacion = fechaDeActualizacion;
    }

    public Empleado() {
    }
}