package br.com.fullstack.m1s10.repository;

import br.com.fullstack.m1s10.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
