package com.example.demo.domain.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class JogoDTO {
    @NotBlank(message = "Campo genero obrigatório")
    private String genero;

    @NotBlank(message = "Campo titulo obrigatório")
    private String titulo;

    @NotBlank(message = "Campo data é obrigatório")
    private String jogoLancamento;

    @NotNull(message = "idPublisher é obrigatória")
    private Integer idPublisher;


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getJogoLancamento() {
        return jogoLancamento;
    }

    public void setJogoLancamento(String jogoLancamento) {
        this.jogoLancamento = jogoLancamento;
    }

    public Integer getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }
}
