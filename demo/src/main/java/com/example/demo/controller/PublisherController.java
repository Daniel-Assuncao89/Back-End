package com.example.demo.controller;

import com.example.demo.domain.Publisher;
import com.example.demo.domain.dto.PublisherDTO;
import com.example.demo.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public List<Publisher> listar(){
        return this.publisherService.listar();
    }

    @GetMapping("/publishers/{idPublisher}")
    public Publisher getPublisher(@PathVariable Integer idPublisher){
        return this.publisherService.getPublisher(idPublisher);
    }

    @PostMapping("/publishers")
    public Publisher salvar(@Valid @RequestBody PublisherDTO dto){
        Publisher pub = this.publisherService.salvar(dto);
        return pub;
    }

    @PutMapping("/publishers/{idPublishers}")
    public Publisher atualizar(@PathVariable Integer idPublishers, @Valid @RequestBody PublisherDTO dto){
        return this.publisherService.atualizar(idPublishers, dto);
    }

    @DeleteMapping("/publishers/{idPublishers}")
    public void deletar(@PathVariable Integer idPublishers){
        this.publisherService.deletar(idPublishers);
    }
}
