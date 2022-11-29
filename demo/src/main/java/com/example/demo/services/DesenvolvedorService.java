package com.example.demo.services;

import com.example.demo.domain.Desenvolvedor;
import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.DesenvolvedorDTO;
import com.example.demo.repositories.DesenvolvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesenvolvedorService {
    @Autowired
    private DesenvolvedorRepository desenvolvedorRepository;

    @Autowired
    private PublisherService publisherService;

    public List<Desenvolvedor> listar(){
        return this.desenvolvedorRepository.findAll();
    }

    public Desenvolvedor getDesenvolvedor(Integer idDesenvolvedor){
        Optional<Desenvolvedor> desenvolvedor = this.desenvolvedorRepository.findById(idDesenvolvedor);

        if(desenvolvedor.isEmpty()){
            throw new RuntimeException("Desenvolvedor não encontrado");
        } else {
            return this.getDesenvolvedor(idDesenvolvedor);
        }
    }

    public Desenvolvedor salvar(DesenvolvedorDTO dto){
        Publisher publisher = this.publisherService.getPublisher(dto.getIdPublisher());

        Desenvolvedor dev = new Desenvolvedor(null, dto.getDesenvolvedorNome(), dto.getDesenvolvedorSetor(),dto.getDesenvolvedorSalario(), publisher);

        return this.desenvolvedorRepository.save(dev);

    }

    public Desenvolvedor atualizar(Integer idDev, DesenvolvedorDTO dto){
        Desenvolvedor dev = this.getDesenvolvedor(idDev);
        Publisher pubs = this.publisherService.getPublisher(dto.getIdPublisher());

        dev.setDesenvolvedorNome(dto.getDesenvolvedorNome());
        dev.setDesenvolvedorSalario(dto.getDesenvolvedorSalario());
        dev.setDesenvolvedorSetor(dto.getDesenvolvedorSetor());
        dev.setPublisher(pubs);

        return this.desenvolvedorRepository.save(dev);
    }

    public void deletar(Integer idDev){
        Desenvolvedor dev = this.getDesenvolvedor(idDev);

        this.desenvolvedorRepository.delete(dev);
    }
}
