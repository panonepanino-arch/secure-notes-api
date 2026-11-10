package io.github.jessedeoliveira.securenotesapi.service;

import io.github.jessedeoliveira.securenotesapi.entity.Nota;
import io.github.jessedeoliveira.securenotesapi.repository.NotaRepository;
import io.github.jessedeoliveira.securenotesapi.repository.UsuarioRepository;
import io.github.jessedeoliveira.securenotesapi.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;

    public NotaService(NotaRepository notaRepository, UsuarioRepository usuarioRepository, CategoriaRepository categoriaRepository) {
        this.notaRepository = notaRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Nota salvar(Nota nota) {
        if (nota.getUsuario() != null && nota.getUsuario().getId() != null) {
            usuarioRepository.findById(nota.getUsuario().getId()).ifPresent(nota::setUsuario);
        }
        if (nota.getCategoria() != null && nota.getCategoria().getId() != null) {
            categoriaRepository.findById(nota.getCategoria().getId()).ifPresent(nota::setCategoria);
        }
        return notaRepository.save(nota);
    }

    public List<Nota> buscarPorUsuario(Long usuarioId) {
        return notaRepository.findByUsuarioId(usuarioId);
    }

    public Optional<Nota> buscarPorId(Long id) {
        return notaRepository.findById(id);
    }

    public Nota atualizar(Long id, Nota notaAtualizada) {
        notaAtualizada.setId(id);
        return salvar(notaAtualizada);
    }

    public void excluir(Long id) {
        notaRepository.deleteById(id);
    }
}