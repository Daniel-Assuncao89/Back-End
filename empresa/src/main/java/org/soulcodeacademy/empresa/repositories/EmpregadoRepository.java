package org.soulcodeacademy.empresa.repositories;

import org.soulcodeacademy.empresa.domain.Dependente;
import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.Endereco;
import org.soulcodeacademy.empresa.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

    List<Empregado> findByEndereco(Endereco endereco);

    List<Empregado> findByProjetos(Projeto projeto);

    @Query(value = "SELECT * FROM empregado_projetos INNER JOIN empregado ON empregado_projetos.empregado_id_empregado = empregado.id_empregado", nativeQuery = true)
    List<Empregado> findByProjeto();
}
