package org.soulcodeacademy.empresa.controller;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.service.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmpregadoController {

    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping("/empregados")
    private List<Empregado> listar(){

        return  this.empregadoService.listar();
    }

    @GetMapping("/empregados/{idEmpregado}")
    private Empregado getEmpregado(@PathVariable Integer idEmpregado){
        return  this.empregadoService.getEmpregado(idEmpregado);
    }

    @PostMapping("/empregados")
    private Empregado salvar(@Valid @RequestBody EmpregadoDTO dto){
        return this.empregadoService.salvar(dto);
    }

    @PutMapping("/empregados/{idEmpregado}")
    private Empregado atualizar(@PathVariable Integer idEmpregado, @Valid @RequestBody EmpregadoDTO dto){
        return this.empregadoService.atualizar(idEmpregado, dto);
    }

    @DeleteMapping("/empregados/{idEmpregado}")
    private void deletar(@PathVariable Integer idEmpregado){
         this.empregadoService.deletar(idEmpregado);
    }
}
