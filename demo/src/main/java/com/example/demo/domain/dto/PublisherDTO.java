package com.example.demo.domain.dto;

import javax.validation.constraints.NotBlank;

public class PublisherDTO {
    @NotBlank(message = "Campo nome é obrigatório")
    private String publishername;
    @NotBlank(message = "Campo Local é obrigatório")
    private String publisherLocal;
    @NotBlank(message = "Campo Fundação é obrigatório")
    private String publisherFoundation;

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
}
