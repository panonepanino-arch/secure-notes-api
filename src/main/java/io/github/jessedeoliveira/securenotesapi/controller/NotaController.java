package io.github.jessedeoliveira.securenotesapi.controller;

import io.github.jessedeoliveira.securenotesapi.entity.Nota;
import io.github.jessedeoliveira.securenotesapi.service.NotaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public Nota salvar(@RequestBody Nota nota) {
        return notaService.salvar(nota);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Nota> buscarPorUsuario(@PathVariable Long usuarioId) {
        return notaService.buscarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public Nota atualizar(@PathVariable Long id, @RequestBody Nota nota) {
        return notaService.atualizar(id, nota);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        notaService.excluir(id);
    }
}