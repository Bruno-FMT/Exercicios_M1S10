package br.com.fullstack.m1s10.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
}
