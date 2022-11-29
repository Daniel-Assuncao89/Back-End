package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Plataforma {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPlataforma;
    @Column(nullable = false, length = 20)
    private String plataformaNome;
    @Column(nullable = false, length = 10)
    private String plataformaLancamento;

    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogo jogo;

    Plataforma (){}

    public Plataforma(Integer idPlataforma, String plataformaNome, String plataformaLancamento, Jogo jogo) {
        this.idPlataforma = idPlataforma;
        this.plataformaNome = plataformaNome;
        this.plataformaLancamento = plataformaLancamento;
        this.jogo = jogo;
    }

    public Integer getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

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

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plataforma that = (Plataforma) o;
        return idPlataforma.equals(that.idPlataforma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlataforma);
    }
}
