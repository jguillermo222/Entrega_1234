package com.GrupoEntrega2.Entrega2.Repository;

import com.GrupoEntrega2.Entrega2.Entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReposityTransaction extends JpaRepository<Transaccion,Long> {

}
