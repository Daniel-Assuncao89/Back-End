package com.example.demo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Publisher {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPublisher;

    @Column(nullable = false, length = 45)
    private String publishername;

    @Column(nullable = false, length = 45)
    private String publisherLocal;

    @Column(nullable = false, length = 10)
    private String publisherFoundation;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Plataforma> linkPlataforma = new ArrayList<>();

    public Publisher(){}

    public Publisher(Integer idPublisher, String publisherName, String publisherLocal, String publisherFoundation) {
        this.idPublisher = idPublisher;
        this.publishername = publisherName;
        this.publisherLocal = publisherLocal;
        this.publisherFoundation = publisherFoundation;
    }

    public Integer getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public String getPublisherLocal() {
        return publisherLocal;
    }

    public void setPublisherLocal(String publisherLocal) {
        this.publisherLocal = publisherLocal;
    }

    public String getPublisherFoundation() {
        return publisherFoundation;
    }

    public void setPublisherFoundation(String publisherFoundation) {
        this.publisherFoundation = publisherFoundation;
    }

    public List<Plataforma> getLinkPlataforma() {
        return linkPlataforma;
    }

    public void setLinkPlataforma(List<Plataforma> linkPlataforma) {
        this.linkPlataforma = linkPlataforma;
    }
}
