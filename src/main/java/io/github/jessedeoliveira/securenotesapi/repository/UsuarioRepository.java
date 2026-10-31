package io.github.jessedeoliveira.securenotesapi.repository;

import io.github.jessedeoliveira.securenotesapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
