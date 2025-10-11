package com.example.demo.controller;

import com.example.demo.conserto.Conserto;
import com.example.demo.conserto.DadosConserto;
import com.example.demo.dao.ConsertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conserto")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto dados) {
        repository.save(new Conserto(dados));
    }
}
