package org.soulcodeacademy.empresa.service;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private EmpregadoService empregadoService;

    public List<Dependente> listar(){
        return this.dependenteRepository.findAll();
    }

    public Dependente getDependente(Integer idDependente){
        return this.dependenteRepository.findById(idDependente).orElseThrow(() -> new RuntimeException("Dependente não encontrado"));
    }

    public Dependente salvar(DependenteDTO dto){
        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());
        return this.dependenteRepository.save(dependente);
    }

    public Dependente atualizar(Integer idDependente, DependenteDTO dto){
        Dependente dependente = this.getDependente(idDependente);

        Empregado empregado = empregadoService.getEmpregado(dto.getIdResponsavel());

        dependente.setNome(dto.getNome());
        dependente.setIdade(dto.getIdade());
        dependente.setResponsavel(empregado);

        return dependenteRepository.save(dependente);
    }

    public void deletar(Integer idDependente){
        Dependente dependente = this.getDependente(idDependente);

        this.dependenteRepository.delete(dependente);
    }
}
