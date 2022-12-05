package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class EmpregadoDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;
    @NotNull(message = "Salario é obrigatório")
    private Double salario;

    @NotNull(message = "IdEndereço é obrigatório")
    private Integer idEndereco;

    private List<Integer> idProjeto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public List<Integer> getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(List<Integer> idProjeto) {
        this.idProjeto = idProjeto;
    }
}
