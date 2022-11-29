package com.example.demo.repositories;

import com.example.demo.domain.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlataformaRepository extends JpaRepository<Plataforma, Integer> {
}
