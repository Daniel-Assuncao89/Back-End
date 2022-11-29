package com.example.demo.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DesenvolvedorDTO {

    @NotBlank(message = "Campo nome é obrigatório")
    private String desenvolvedorNome;

    @NotBlank(message = "Campo setor é obrigatório")
    private String desenvolvedorSetor;

    @NotNull(message = "Campos salario é obrigatorio")
    @Max(value = 40000, message = "Valor invalido")
    @Min(value = 4000, message = "Valor invalido")
    private Double desenvolvedorSalario;

    @NotNull(message = "IdPublisher é obrigatório")
    private Integer idPublisher;

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

    public Integer getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }
}
