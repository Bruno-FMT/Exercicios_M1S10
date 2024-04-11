package br.com.fullstack.m1s10.service;

import br.com.fullstack.m1s10.entity.AlunoEntity;
import br.com.fullstack.m1s10.erro.ResourceNotFoundException;
import br.com.fullstack.m1s10.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoEntity> getAllAlunos(){
        return alunoRepository.findAll();
    }

    public ResponseEntity<AlunoEntity> getAlunoById(Long id){
        AlunoEntity aluno = alunoRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException(
                                "Aluno", "id", id
                        )
                );

        return ResponseEntity.ok(aluno);
    }

    public AlunoEntity createALuno(AlunoEntity alunoEntity){
        return alunoRepository.save(alunoEntity);
    }

    public AlunoEntity updateAluno(Long id, AlunoEntity alunoChanged){
        AlunoEntity alunoEntity = alunoRepository.findById(id)
                .orElseThrow(
                ()-> new ResourceNotFoundException(
                        "Aluno", "id", id
                ));

            alunoEntity.setNome(alunoChanged.getNome());

            return alunoRepository.save(alunoEntity);
    }

    public void deleteAluno(Long id){
        AlunoEntity alunoEntity = alunoRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException(
                                "Aluno", "id", id
                        )
                );

            alunoRepository.delete(alunoEntity);
    }
}
