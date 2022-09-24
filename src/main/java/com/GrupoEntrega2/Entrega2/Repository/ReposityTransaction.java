package com.GrupoEntrega2.Entrega2.Repository;

import com.GrupoEntrega2.Entrega2.repositorio.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposityTransaction extends JpaRepository<Transaccion,Long> {

}
