package org.soulcodeacademy.empresa.service;

import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EmpregadoRepository empregadoRepository;

    public List<Endereco> listar(){
        return this.enderecoRepository.findAll();
    }

    public Endereco getEndereco(Integer idEndereco){
        return this.enderecoRepository.findById(idEndereco).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public Endereco salvar(EnderecoDTO dto){
        Endereco endereco = new Endereco(null,dto.getCidade(), dto.getUf());

        return this.enderecoRepository.save(endereco);
    }

    public Endereco atualizar(Integer idEndereco, EnderecoDTO dto){
        Endereco endereco = this.getEndereco(idEndereco);
        endereco.setCidade(dto.getCidade());
        endereco.setUf(dto.getUf());

        return this.enderecoRepository.save(endereco);
    }

    public void deletar(Integer idEndereco){
        Endereco endereco = this.getEndereco(idEndereco);
        this.enderecoRepository.delete(endereco);
    }
}
