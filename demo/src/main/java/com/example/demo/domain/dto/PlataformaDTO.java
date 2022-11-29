package com.example.demo.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlataformaDTO {

    @NotBlank(message = "Nome da Plataforma é obrigatório")
    private String plataformaNome;

    @NotBlank(message = "Data de lançamento é obrigatório")
    private String plataformaLancamento;

    @NotNull(message = "idJogo é obrigatória")
    private Integer idJogo;


    public String getPlataformaNome() {
        return plataformaNome;
    }

    public void setPlataformaNome(String plataformaNome) {
        this.plataformaNome = plataformaNome;
    }

    public String getPlataformaLancamento() {
        return plataformaLancamento;
    }

    public void setPlataformaLancamento(String plataformaLancamento) {
        this.plataformaLancamento = plataformaLancamento;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }
}
