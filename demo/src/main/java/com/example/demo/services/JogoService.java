package com.example.demo.services;

import com.example.demo.domain.Jogo;
import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.JogoDTO;
import com.example.demo.repositories.JogoRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private PublisherService publisherService;

    public List<Jogo> listar(){
        return this.jogoRepository.findAll();
    }

    public Jogo getJogo(Integer idJogo){
        Optional<Jogo> jogo = this.jogoRepository.findById(idJogo);

        if(jogo.isEmpty()){
            throw new RuntimeException("Jogo não encontrado");
        } else {
            return jogo.get();
        }
    }

    public Jogo salvar(JogoDTO dto){
        Publisher publisher = this.publisherService.getPublisher(dto.getIdPublisher());
        Jogo jogo = new Jogo(null, dto.getGenero(), dto.getTitulo(), dto.getJogoLancamento(), publisher);

        this.jogoRepository.save(jogo);

        return jogo;
    }

    public Jogo atualizar(Integer idJogo, JogoDTO dto){
        Jogo jogo = this.getJogo(idJogo);

        Publisher publisher = this.publisherService.getPublisher(dto.getIdPublisher());

        jogo.setJogoLancamento(dto.getJogoLancamento());
        jogo.setGenero(dto.getGenero());
        jogo.setTitulo(dto.getTitulo());
        jogo.setPublisher(publisher);

        return this.jogoRepository.save(jogo);
    }

    public void deletar(Integer idJogo){
        Jogo jogo = this.getJogo(idJogo);

        this.jogoRepository.delete(jogo);
    }
}
