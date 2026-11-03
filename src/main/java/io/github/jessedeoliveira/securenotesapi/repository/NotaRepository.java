package io.github.jessedeoliveira.securenotesapi.repository;

import io.github.jessedeoliveira.securenotesapi.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByUsuarioId(Long usuarioId);
}