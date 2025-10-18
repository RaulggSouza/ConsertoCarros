package com.example.demo.veiculo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotEmpty
        String marca,

        @NotEmpty
        String modelo,

        @Pattern(regexp = "\\d{4}")
        String ano,

        String cor
)
{
        public DadosVeiculo(Veiculo veiculo) {
                this(veiculo.getMarca(),veiculo.getModelo(),veiculo.getAno(),veiculo.getCor());
        }
}
