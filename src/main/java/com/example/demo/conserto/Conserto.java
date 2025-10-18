package com.example.demo.conserto;

import com.example.demo.mecanico.Mecanico;
import com.example.demo.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String dataEntrada;
    String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosConserto dadosConserto) {
        this.dataEntrada = dadosConserto.dataEntrada();
        this.dataSaida = dadosConserto.dataSaida();
        this.mecanico = new Mecanico(dadosConserto.dadosMecanico());
        this.veiculo = new Veiculo(dadosConserto.dadosVeiculo());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizarConserto dados){
        if (dados.dataSaida() != null) this.dataSaida = dados.dataSaida();
        if (dados.dadosMecanico() != null) this.mecanico.atualizarInformacoes(dados.dadosMecanico());
    }

    public void excluir(){
        this.ativo = false;
    }
}
