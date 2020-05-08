package felipe.huff.databasetrabalho.controle;



import felipe.huff.databasetrabalho.modelo.AlunoEntity;
import felipe.huff.databasetrabalho.repositorios.AlunoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoControle {  //classe controladora


    @Autowired
    private AlunoRepositorio alunoRepositorio;


    @GetMapping
    public ResponseEntity<List<AlunoEntity>> findAll (){  // get
        return new ResponseEntity<List<AlunoEntity>>(
                (List<AlunoEntity>) this.alunoRepositorio.findAll(),
                new HttpHeaders(), HttpStatus.OK);//error 404
    }


    //get
    @GetMapping(path = "/{id}")
    // só um objeto
    public ResponseEntity<AlunoEntity> findById(@PathVariable ("id") long id) {
        if(this.alunoRepositorio.findById(id).isPresent()){
            return new ResponseEntity<AlunoEntity>(
                    this.alunoRepositorio.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<AlunoEntity>(HttpStatus.NOT_FOUND);
    }

    //post
    @PostMapping
    public ResponseEntity<AlunoEntity> cadastrar (@RequestBody AlunoEntity alunoEntity) {
        return new ResponseEntity<AlunoEntity> (
                this.alunoRepositorio.save(alunoEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }

   //put
    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoEntity> atualizar (@PathVariable("id") long id,
                                                  @RequestBody AlunoEntity funcionarioEntity) throws Exception {

        if(id == 0 || !this.alunoRepositorio.existsById(id)){
            throw  new Exception("Código não encontrado ou inexistente!");

        }
        return new ResponseEntity<AlunoEntity>(
                this.alunoRepositorio.save(funcionarioEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    //deletar

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlunoEntity> deletar (@PathVariable("id") long id ){
        this.alunoRepositorio.deleteById(id);
        return new ResponseEntity<AlunoEntity>(new HttpHeaders(), HttpStatus.OK);
    }

}// fim da classe
