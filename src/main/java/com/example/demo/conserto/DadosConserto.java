package com.example.demo.conserto;

import com.example.demo.mecanico.DadosMecanico;
import com.example.demo.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$")
        String dataEntrada,

        @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$")
        String dataSaida,

        @Valid
        DadosMecanico dadosMecanico,

        @Valid
        DadosVeiculo dadosVeiculo) {
}
