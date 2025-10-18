package com.example.demo.conserto;

import com.example.demo.mecanico.DadosMecanico;
import com.example.demo.veiculo.DadosVeiculo;

public record DadosDetalhamentoConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        DadosMecanico dadosMecanico,
        DadosVeiculo dadosVeiculo) {

    public DadosDetalhamentoConserto(Conserto conserto) {
        this(conserto.getId(),
        conserto.getDataEntrada(),
        conserto.getDataSaida(),
        new DadosMecanico(conserto.getMecanico()),
        new DadosVeiculo(conserto.getVeiculo()));
    }
}
