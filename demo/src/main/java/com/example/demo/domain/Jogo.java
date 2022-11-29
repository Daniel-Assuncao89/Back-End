package com.example.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJogo;

    @Column(nullable = false, length = 45)
    private String genero;

    @Column(nullable = false, length = 45)
    private String titulo;

    @Column(nullable = false, length = 10)
    private String jogoLancamento;

    @ManyToOne
    @JoinColumn(name = "id_Publisher")
    private Publisher publisher;

    public Jogo (){}

    public Jogo(Integer idJogo, String genero, String titulo, String jogoLancamento, Publisher publisher) {
        this.idJogo = idJogo;
        this.genero = genero;
        this.titulo = titulo;
        this.jogoLancamento = jogoLancamento;
        this.publisher = publisher;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Integer idJogo) {
        this.idJogo = idJogo;
    }

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

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
