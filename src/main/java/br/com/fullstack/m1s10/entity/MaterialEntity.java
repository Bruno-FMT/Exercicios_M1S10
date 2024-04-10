package br.com.fullstack.m1s10.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private AgendaEntity agendaEntity;

    private String descricao;
    private String url;
}
