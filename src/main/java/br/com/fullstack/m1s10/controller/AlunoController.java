package br.com.fullstack.m1s10.controller;

import br.com.fullstack.m1s10.entity.AlunoEntity;
import br.com.fullstack.m1s10.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoEntity> getAll(){
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> getById(@PathVariable Long id){
        AlunoEntity alunoEntity = alunoService.getAlunoById(id).getBody();

        return alunoEntity != null
                ? ResponseEntity.ok(alunoEntity)
                : ResponseEntity.notFound().build();

    }

    @PostMapping
    public AlunoEntity post(@RequestBody AlunoEntity alunoEntity){
        return alunoService.createALuno(alunoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> update(
            @PathVariable Long id,
            @RequestBody AlunoEntity alunoChanges
    ){
        AlunoEntity alunoEntity = alunoService.updateAluno(id, alunoChanges);

        return alunoEntity != null
                ? ResponseEntity.ok(alunoEntity)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        alunoService.deleteAluno(id);
        return ResponseEntity.ok().build();
    }
}
