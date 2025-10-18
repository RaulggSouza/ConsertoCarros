package com.example.demo.conserto;


public record DadosInformacoesConserto(
        String dataEntrada,
        String dataSaida,
        String nome,
        String marca,
        String modelo
) {
    public DadosInformacoesConserto(Conserto conserto) {
        this(conserto.getDataEntrada(), conserto.getDataSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo());
    }
}
