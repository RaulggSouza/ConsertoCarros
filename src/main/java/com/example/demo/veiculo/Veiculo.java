package com.example.demo.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Veiculo(DadosVeiculo dadosVeiculo) {
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.ano = dadosVeiculo.ano();
        this.cor = dadosVeiculo.cor();
    }
}
