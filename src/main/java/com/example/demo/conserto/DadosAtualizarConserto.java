package com.example.demo.conserto;

import com.example.demo.mecanico.DadosMecanico;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarConserto(
    @NotNull
    Long id,

    @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$")
    String dataSaida,

    DadosMecanico dadosMecanico
) {}
