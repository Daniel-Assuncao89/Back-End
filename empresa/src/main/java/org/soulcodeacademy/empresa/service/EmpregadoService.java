package org.soulcodeacademy.empresa.service;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private DependenteService dependenteService;

    public List<Empregado> listar() {
        return this.empregadoRepository.findAll();
    }

    public Empregado getEmpregado(Integer idEmpregado) {
        return this.empregadoRepository.findById(idEmpregado).orElseThrow(() -> new RuntimeException("Empregado não encontrado"));
    }

    public Empregado salvar(EmpregadoDTO dto){
        Endereco endereco = enderecoService.getEndereco(dto.getIdEndereco());


        Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
        empregado.setEndereco(endereco);

        return this.empregadoRepository.save(empregado);
    }

    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto){
        Empregado empregado = this.getEmpregado(idEmpregado);

        Projeto projeto = projetoService.getProjeto(dto.getIdProjeto());

        Endereco endereco = enderecoService.getEndereco(dto.getIdEndereco());
        empregado.setEndereco(endereco);

        empregado.setEndereco(endereco);
        empregado.setEmail(dto.getEmail());
        empregado.setNome(dto.getNome());
        empregado.getProjetos().add(projeto);

        return this.empregadoRepository.save(empregado);
    }

    public void deletar(Integer idEmpregado){
        Empregado empregado = this.getEmpregado(idEmpregado);

        Endereco endereco = empregado.getEndereco();

        empregadoRepository.delete(empregado);

        enderecoService.deletar(endereco.getIdEndereco());
    }
}
