package com.GrupoEntrega2.Entrega2.Repository;


import com.GrupoEntrega2.Entrega2.repositorio.PerfilDeEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPerfilDeEmpleado extends JpaRepository<PerfilDeEmpleado,Long> {
}
