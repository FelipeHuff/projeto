package felipe.huff.databasetrabalho.modelo;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

// JPA - Java Persistence API
@Entity
@Table(name= "aluno")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;


}


