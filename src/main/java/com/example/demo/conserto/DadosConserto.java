package com.example.demo.conserto;

import com.example.demo.mecanico.DadosMecanico;
import com.example.demo.veiculo.DadosVeiculo;

public record DadosConserto
        (String dataEntrada,
        String dataSaida,
        DadosMecanico dadosMecanico,
        DadosVeiculo dadosVeiculo) {
}
