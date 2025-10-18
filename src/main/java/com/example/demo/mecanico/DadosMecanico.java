package com.example.demo.mecanico;

import jakarta.validation.constraints.NotEmpty;

public record DadosMecanico(
        @NotEmpty
        String nome,

        int anosDeExperiencia) {
        public DadosMecanico(Mecanico mecanico) {
                this(mecanico.getNome(), mecanico.getAnosDeExperiencia());
        }
}
