package felipe.huff.databasetrabalho.repositorios;

import felipe.huff.databasetrabalho.modelo.AlunoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepositorio extends CrudRepository<AlunoEntity, Long> {


}
