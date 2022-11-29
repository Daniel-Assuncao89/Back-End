package com.example.demo.services;

import com.example.demo.domain.Jogo;
import com.example.demo.domain.Plataforma;
import com.example.demo.domain.dto.PlataformaDTO;
import com.example.demo.repositories.PlataformaRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlataformaService {
    @Autowired
    private PlataformaRepository plataformaRepository;
    @Autowired
    private JogoService jogoService;

    public List<Plataforma> listar(){
        return this.plataformaRepository.findAll();
    }

    public Plataforma getPlataforma(Integer idPlataforma){
        Optional<Plataforma> plataforma = this.plataformaRepository.findById(idPlataforma);

        if(plataforma.isEmpty()){
            throw new RuntimeException("Plataforma não encontrada");
        } else {
            return plataforma.get();
        }
    }

    public Plataforma salvar(PlataformaDTO dto){
        Jogo jogo = this.jogoService.getJogo(dto.getIdJogo());
        Plataforma nova = new Plataforma(null, dto.getPlataformaNome(), dto.getPlataformaLancamento(), jogo);

        this.plataformaRepository.save(nova);
        return nova;
    }

    public Plataforma atualizar(Integer id, PlataformaDTO dto){
        Plataforma plataforma = this.getPlataforma(id);

        Jogo jogo = this.jogoService.getJogo(dto.getIdJogo());

        plataforma.setPlataformaNome(dto.getPlataformaNome());
        plataforma.setPlataformaLancamento(dto.getPlataformaLancamento());
        plataforma.setJogo(jogo);

        return this.plataformaRepository.save(plataforma);
    }

    public void deletar(Integer id){
        Plataforma plataforma = this.getPlataforma(id);

        this.plataformaRepository.delete(plataforma);
    }
}
