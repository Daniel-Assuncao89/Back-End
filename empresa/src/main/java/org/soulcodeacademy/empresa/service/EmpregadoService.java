package org.soulcodeacademy.empresa.service;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.domain.dto.EnderecoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.repositories.EnderecoRepository;
import org.soulcodeacademy.empresa.service.errors.ParametrosInsuficientesError;
import org.soulcodeacademy.empresa.service.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ProjetoService projetoService;


    public List<Empregado> listar() {
        return this.empregadoRepository.findAll();
    }

    public List<Empregado> listarPorEndereco(Integer idEndereco){
        Endereco endereco = enderecoService.getEndereco(idEndereco);

        return  empregadoRepository.findByEndereco(endereco);
    }

    public List<Empregado> listarPorProjeto(){
        return empregadoRepository.findByProjeto();
    }

    public Empregado getEmpregado(Integer idEmpregado) {
        return this.empregadoRepository.findById(idEmpregado).orElseThrow(() -> new RecursoNaoEncontradoError("Empregado não encontrado"));
    }


    public Empregado salvar(EmpregadoDTO dto){
        Endereco endereco = enderecoService.getEndereco(dto.getIdEndereco());


        Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
        empregado.setEndereco(endereco);

        for(Empregado emp : this.listar()){
            if(emp.getEndereco() != endereco){
                empregado.setEndereco(endereco);
            }else{
                throw new ParametrosInsuficientesError("Endereço em utilização");
            }
        }

        return this.empregadoRepository.save(empregado);
    }

    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto){
        Empregado empregado = this.getEmpregado(idEmpregado);
        Endereco endereco = enderecoService.getEndereco(dto.getIdEndereco());

        List<Projeto> projetos = new ArrayList<>();

        for(Integer idProjeto : dto.getIdProjeto()){
            Projeto projeto = this.projetoService.getProjeto(idProjeto);
            projetos.add(projeto);
        }

        for(Empregado emp : this.listar()){
            if(emp.getEndereco() != endereco){
                empregado.setEndereco(endereco);
            }else{
                throw new ParametrosInsuficientesError("Endereço em utilização");
            }
        }

        empregado.setSalario(dto.getSalario());
        empregado.setEmail(dto.getEmail());
        empregado.setNome(dto.getNome());
        empregado.setProjetos(projetos);

        return this.empregadoRepository.save(empregado);
    }

    public void deletar(Integer idEmpregado){
        Empregado empregado = this.getEmpregado(idEmpregado);

        Endereco endereco = empregado.getEndereco();

        empregadoRepository.delete(empregado);

        enderecoService.deletar(endereco.getIdEndereco());
    }
}
