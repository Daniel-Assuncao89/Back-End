package com.example.demo.controller;

import com.example.demo.domain.Jogo;
import com.example.demo.domain.dto.JogoDTO;
import com.example.demo.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JogoController {
    @Autowired
    private JogoService jogoService;

    @GetMapping("/jogos")
    public List<Jogo> listar(){
        return jogoService.listar();
    }

    @GetMapping("/jogos/{idJogo}")
    public Jogo getJogo(@PathVariable Integer idJogo){
        return this.jogoService.getJogo(idJogo);
    }

    @PostMapping("/jogos")
    public Jogo salvar(@Valid @RequestBody JogoDTO dto){
        Jogo jogo = this.jogoService.salvar(dto);
        return  jogo;
    }

    @PutMapping("/jogos/{idJogo}")
    public Jogo atualizar(@PathVariable Integer idJogo, @Valid @RequestBody JogoDTO dto){
        return this.jogoService.atualizar(idJogo, dto);
    }

    @DeleteMapping("/jogos/{idJogo}")
    public void deletar(@PathVariable Integer idJogo){
        this.jogoService.deletar(idJogo);
    }
}
