package br.com.fullstack.m1s10.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class AgendaEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private AlunoEntity alunoEntity;

    @ManyToOne
    private TutorEntity tutorEntity;

    private LocalDate data_agendamento;
    private String status;
    private String tema;
    private String descricao;
}
