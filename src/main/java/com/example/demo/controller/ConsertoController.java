package com.example.demo.controller;

import com.example.demo.conserto.*;
import com.example.demo.dao.ConsertoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados,
                                    UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);

        repository.save(conserto);

        var uri = uriBuilder.path("consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping
    public ResponseEntity listar(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAll(paginacao));
    }

    @GetMapping("informacoes")
    public ResponseEntity listarInformacoes() {
        return ResponseEntity.ok(repository.findAllByAtivoTrue().stream().map(DadosInformacoesConserto::new).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> conserto = repository.findById(id);

        if (conserto.isPresent()) {
            Conserto c = conserto.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(c));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarConserto dados) {
        try {
            Conserto conserto = repository.getReferenceById(dados.id());
            conserto.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto c = repository.getReferenceById(id);
        c.excluir();
        return ResponseEntity.noContent().build();
    }
}
