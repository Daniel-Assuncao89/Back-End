package com.example.demo.services;

import com.example.demo.domain.Desenvolvedor;
import com.example.demo.domain.Jogo;
import com.example.demo.domain.Plataforma;
import com.example.demo.domain.Publisher;
import com.example.demo.repositories.DesenvolvedorRepository;
import com.example.demo.repositories.JogoRepository;
import com.example.demo.repositories.PlataformaRepository;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopulateService {
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PlataformaRepository plataformaRepository;

    @Autowired
    private DesenvolvedorRepository desenvolvedorRepository;

    public void populate(){
        Publisher p1 = new Publisher(null, "Konami", "teste1", "1999/10/10");
        Publisher p2 = new Publisher(null, "Naugthy Dog", "teste2", "1989/10/10");

        Jogo j1 = new Jogo(null, "Ação", "God of war", "1989/05/05", p1);
        Jogo j2 = new Jogo(null, "Aventura", "Hogwarts Legacy", "2022/05/05", p2);

        Plataforma plat1 = new Plataforma(null,"Xbox", "2022/01/01", j1);
        Plataforma plat2 = new Plataforma(null,"Ps5", "2020/01/01", j1);
        Plataforma plat3 = new Plataforma(null,"PC", "2022/01/01", j2);

        Desenvolvedor dev1 = new Desenvolvedor(null, "João da Silva", "Back End", 5000.0, p1);
        Desenvolvedor dev2 = new Desenvolvedor(null, "Guilherme da Silva", "Back End", 5000.0, p2);
        Desenvolvedor dev3 = new Desenvolvedor(null, "Leticia da Silva", "Front End", 5000.0, p1);
        Desenvolvedor dev4 = new Desenvolvedor(null, "Fernanda da Silva", "Front End", 5000.0, p2);

        this.publisherRepository.save(p1);
        this.publisherRepository.save(p2);
        this.jogoRepository.save(j1);
        this.jogoRepository.save(j2);
        this.plataformaRepository.save(plat1);
        this.plataformaRepository.save(plat2);
        this.plataformaRepository.save(plat3);
        this.desenvolvedorRepository.save(dev1);
        this.desenvolvedorRepository.save(dev2);
        this.desenvolvedorRepository.save(dev3);
        this.desenvolvedorRepository.save(dev4);
    }
}
