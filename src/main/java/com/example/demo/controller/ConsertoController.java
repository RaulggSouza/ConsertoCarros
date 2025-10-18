package com.example.demo.controller;

import com.example.demo.conserto.Conserto;
import com.example.demo.conserto.DadosConserto;
import com.example.demo.conserto.DadosInformacoesConserto;
import com.example.demo.dao.ConsertoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados) {
        repository.save(new Conserto(dados));
    }

    @GetMapping
    public Page<Conserto> listar(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("informacoes")
    public List<DadosInformacoesConserto> listarInformacoes() {
        return repository.findAll().stream().map(DadosInformacoesConserto::new).toList();
    }
}
