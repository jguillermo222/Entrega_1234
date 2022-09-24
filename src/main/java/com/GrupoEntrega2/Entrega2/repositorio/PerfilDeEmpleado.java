package com.GrupoEntrega2.Entrega2.repositorio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="perfil")
@Data

public class PerfilDeEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerfilDeEmpleado;
    @Column
    private String image;
    @Column
    private String telefono;

    //connectores
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name="empleado_id")
    private Empleado empleado;

    @Column
    private String celular;
    @Column
    private Date fechaDeCreacion;
    @Column
    private Date fechaDeActualizacion;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
