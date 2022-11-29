package com.example.demo.controller;

import com.example.demo.domain.Desenvolvedor;
import com.example.demo.domain.dto.DesenvolvedorDTO;
import com.example.demo.repositories.PublisherRepository;
import com.example.demo.services.DesenvolvedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DesenvolvedorController {

    @Autowired
    private DesenvolvedorService desenvolvedorService;

    @GetMapping("/desenvolvedores")
    public List<Desenvolvedor> listar(){ return this.desenvolvedorService.listar(); }

    @GetMapping("/desenvolvedores/{idDev}")
    public Desenvolvedor getDev(@PathVariable Integer idDev){
        return this.desenvolvedorService.getDesenvolvedor(idDev);
    }

    @PostMapping("/desenvolvedores")
    public Desenvolvedor salvaar(@Valid @RequestBody DesenvolvedorDTO dto){
        return this.desenvolvedorService.salvar(dto);
    }

    @PutMapping("/desenvolvedores/{idDev}")
    public Desenvolvedor atualizar(@PathVariable Integer idDev, @Valid @RequestBody DesenvolvedorDTO dto){
        return this.desenvolvedorService.atualizar(idDev, dto);
    }

    @DeleteMapping("/desenvolvedores/{idDev}")
    public void deletar(@PathVariable Integer idDev){
        this.desenvolvedorService.deletar(idDev);
    }
}
