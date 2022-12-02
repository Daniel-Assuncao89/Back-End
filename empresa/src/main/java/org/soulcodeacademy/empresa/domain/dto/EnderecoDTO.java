package org.soulcodeacademy.empresa.domain.dto;

import javax.validation.constraints.NotBlank;

public class EnderecoDTO {
    @NotBlank(message = "Cidade é obrigatório")
    private String cidade;

    @NotBlank(message = "UF é obrigatório")
    private String uf;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
