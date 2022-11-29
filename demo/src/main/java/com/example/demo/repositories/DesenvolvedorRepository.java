package com.example.demo.repositories;

import com.example.demo.domain.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Integer> {
}
