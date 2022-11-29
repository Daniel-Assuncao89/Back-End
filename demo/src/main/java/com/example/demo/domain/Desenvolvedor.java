package com.example.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Desenvolvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesenvolvedor;

    @Column(nullable = false, length = 30)
    private String desenvolvedorNome;
    @Column(nullable = false, length = 10)
    private String desenvolvedorSetor;

    @Column(nullable = false)
    private Double desenvolvedorSalario;

    @ManyToOne
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;

    public Desenvolvedor (){}
    public Desenvolvedor(Integer idDesenvolvedor, String desenvolvedorNome, String desenvolvedorSetor, Double desenvolvedorSalario, Publisher publisher) {
        this.idDesenvolvedor = idDesenvolvedor;
        this.desenvolvedorNome = desenvolvedorNome;
        this.desenvolvedorSetor = desenvolvedorSetor;
        this.desenvolvedorSalario = desenvolvedorSalario;
        this.publisher = publisher;
    }

    public Integer getIdDesenvolvedor() {
        return idDesenvolvedor;
    }

    public void setIdDesenvolvedor(Integer idDesenvolvedor) {
        this.idDesenvolvedor = idDesenvolvedor;
    }

    public String getDesenvolvedorNome() {
        return desenvolvedorNome;
    }

    public void setDesenvolvedorNome(String desenvolvedorNome) {
        this.desenvolvedorNome = desenvolvedorNome;
    }

    public String getDesenvolvedorSetor() {
        return desenvolvedorSetor;
    }

    public void setDesenvolvedorSetor(String desenvolvedorSetor) {
        this.desenvolvedorSetor = desenvolvedorSetor;
    }

    public Double getDesenvolvedorSalario() {
        return desenvolvedorSalario;
    }

    public void setDesenvolvedorSalario(Double desenvolvedorSalario) {
        this.desenvolvedorSalario = desenvolvedorSalario;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
