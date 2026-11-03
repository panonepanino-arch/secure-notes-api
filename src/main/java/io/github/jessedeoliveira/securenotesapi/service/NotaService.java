package io.github.jessedeoliveira.securenotesapi.service;

import io.github.jessedeoliveira.securenotesapi.entity.Nota;
import io.github.jessedeoliveira.securenotesapi.repository.NotaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public Nota salvar(Nota nota) {
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
        return notaRepository.save(notaAtualizada);
    }

    public void excluir(Long id) {
        notaRepository.deleteById(id);
    }
}