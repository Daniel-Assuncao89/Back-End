package com.example.demo.controller;

import com.example.demo.domain.Plataforma;
import com.example.demo.domain.dto.PlataformaDTO;
import com.example.demo.services.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @GetMapping("/plataformas")
    public List<Plataforma> listar(){
        return this.plataformaService.listar();
    }

    @GetMapping("/plataformas/{idPlataforma}")
    public Plataforma getPlataforma(@PathVariable Integer idPlataforma){
        return this.plataformaService.getPlataforma(idPlataforma);
    }

    @PostMapping("/plataformas")
    public Plataforma salvar(@Valid @RequestBody PlataformaDTO dto){
        return this.plataformaService.salvar(dto);
    }

    @PutMapping("/plataformas/{idPlataforma}")
    public Plataforma atualizar(@PathVariable Integer idPlataforma, @Valid @RequestBody PlataformaDTO dto){
        return this.plataformaService.atualizar(idPlataforma, dto);
    }

    @DeleteMapping("/plataformas/{idPlataforma}")
    public void deletar(@PathVariable Integer idPlataforma){
        this.plataformaService.deletar(idPlataforma);
    }
}
