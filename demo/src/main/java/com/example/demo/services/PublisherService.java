package com.example.demo.services;

import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.PublisherDTO;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> listar(){
        return this.publisherRepository.findAll();
    }

    public Publisher getPublisher(Integer idPublisher){
        Optional<Publisher> pub = this.publisherRepository.findById(idPublisher);

        if(pub.isEmpty()){
            throw new RuntimeException("Publisher não encontrada");
        } else {
            return pub.get();
        }
    }

    public Publisher salvar(PublisherDTO dto) {
        Publisher pub = new Publisher(null, dto.getPublishername(), dto.getPublisherLocal(), dto.getPublisherFoundation());
        return pub;
    }

    public Publisher atualizar(Integer idPublisher, PublisherDTO dto){
        Publisher publisher = this.getPublisher(idPublisher);

        publisher.setPublisherFoundation(dto.getPublisherFoundation());
        publisher.setPublisherLocal(dto.getPublisherLocal());
        publisher.setPublishername(dto.getPublishername());

        return this.publisherRepository.save(publisher);
    }

    public void deletar(Integer idPublisher){
        Publisher publisher = this.getPublisher(idPublisher);

        this.publisherRepository.delete(publisher);
    }
}
