package io.github.jessedeoliveira.securenotesapi.repository;

import io.github.jessedeoliveira.securenotesapi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
