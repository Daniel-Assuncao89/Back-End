package org.soulcodeacademy.empresa.service;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.repositories.DependenteRepository;
import org.soulcodeacademy.empresa.service.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.service.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
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

    public List<Dependente> listarPorEmpregado(Integer idEmpregado){
        Empregado empregado = empregadoService.getEmpregado(idEmpregado);

        return dependenteRepository.findByResponsavel(empregado);
    }

    public Dependente getDependente(Integer idDependente){
        return this.dependenteRepository.findById(idDependente).orElseThrow(() -> new RecursoNaoEncontradoError("Dependente não encontrado"));
    }

    public Dependente salvar(DependenteDTO dto){

        Dependente dependente = new Dependente(null, dto.getNome(), dto.getIdade());

        Empregado empregado = empregadoService.getEmpregado(dto.getIdResponsavel());

        dependente.setResponsavel(empregado);

        return this.dependenteRepository.save(dependente);
    }

    public Dependente atualizar(Integer idDependente, DependenteDTO dto){
        if(dto.getIdResponsavel() == null){
            throw new ParametrosInsuficientesError("id é obrigatório");
        }
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
