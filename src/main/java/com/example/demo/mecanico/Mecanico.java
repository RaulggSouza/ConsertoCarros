package com.example.demo.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosDeExperiencia;

    public Mecanico(DadosMecanico dadosMecanico) {
        this.nome = dadosMecanico.nome();
        this.anosDeExperiencia = dadosMecanico.anosDeExperiencia();
    }

    public void atualizarInformacoes(DadosMecanico dados) {
        if(dados.nome() != null) this.nome = dados.nome();
        if(dados.anosDeExperiencia() >= 0) this.anosDeExperiencia = dados.anosDeExperiencia();
    }
}
