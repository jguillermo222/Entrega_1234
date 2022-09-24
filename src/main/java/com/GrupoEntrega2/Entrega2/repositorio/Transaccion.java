package com.GrupoEntrega2.Entrega2.repositorio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transacciones")
@Data
public class Transaccion {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTransaccion;
    @Column
    private String concepto;
    @Column
    private float monto;

    //conectores

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_empleado")  //4
    private Empleado empleado;

    //conectores

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "id_empresa")   //5
    private Empresa empresa;

    @Column
    private Date fechaDeCreacion;
    @Column
    private Date fechaDeActualizacion;


    public Transaccion(long idTransaccion, String concepto, float monto, Empleado empleado, Empresa empresa, Date fechaDeCreacion, Date fechaDeActualizacion) {
        this.idTransaccion = idTransaccion;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeActualizacion = fechaDeActualizacion;
    }

    public Transaccion() {
    }

    public Transaccion(long idTransaccion, String concepto) {
        this.idTransaccion = idTransaccion;
        this.concepto = concepto;
    }
}