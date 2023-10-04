package harjoitustyo.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.harjoitustyo.domain.Category;
import harjoitustyo.harjoitustyo.domain.CategoryRepository;
import harjoitustyo.harjoitustyo.domain.Sushi;
import harjoitustyo.harjoitustyo.domain.SushiRepository;

@SpringBootApplication
public class HarjoitustyoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SushiRepository repository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("maki"));
			crepository.save(new Category("nigiri"));
			crepository.save(new Category("sashimi"));
			crepository.save(new Category("temaki"));
			
			repository.save(new Sushi("sake", "salmon", 3.00, crepository.findByName("maki").get(0)));
			repository.save(new Sushi("tamago", "egg", 2.00, crepository.findByName("nigiri").get(0)));
			repository.save(new Sushi("ebi", "shrimp", 2.00, crepository.findByName("nigiri").get(0)));
			//crepository.findByName("nigiri").get(0),
		};
	}

}
