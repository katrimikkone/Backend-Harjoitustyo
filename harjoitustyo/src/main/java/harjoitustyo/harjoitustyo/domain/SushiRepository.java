package harjoitustyo.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SushiRepository extends CrudRepository<Sushi, Long>{
	List<Sushi> findByName(String name);
}
