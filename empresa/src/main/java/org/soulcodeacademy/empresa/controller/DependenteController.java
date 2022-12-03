package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.dto.DependenteDTO;
import org.soulcodeacademy.empresa.service.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DependenteController {

    @Autowired
    private DependenteService dependenteService;

    @GetMapping("/dependentes")
    public List<Dependente> listar(){
        return dependenteService.listar();
    }
    @GetMapping("/dependentes/{idDependente}")
    public Dependente getDependente(@PathVariable Integer idDependente){
        return dependenteService.getDependente(idDependente);
    }

    @GetMapping("/dependentes/empregado")
    public List<Dependente> listarPorEmpregado(@RequestParam Integer idEmpregado){
        return  dependenteService.listarPorEmpregado(idEmpregado);
    }

    @PostMapping("/dependentes")
    private Dependente salvar(@Valid @RequestBody DependenteDTO dto){
        return dependenteService.salvar(dto);
    }

    @PutMapping("/dependentes/{idDependente}")
    private Dependente atualizar(@PathVariable Integer idDependente, @Valid @RequestBody DependenteDTO dto){
        return dependenteService.atualizar(idDependente, dto);
    }

    @DeleteMapping("/dependentes/{idDependente}")
    private void deletar(@PathVariable Integer idDependente){
        dependenteService.deletar(idDependente);
    }
}
