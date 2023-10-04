package harjoitustyo.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.harjoitustyo.domain.Sushi;
import harjoitustyo.harjoitustyo.domain.SushiRepository;

@SpringBootApplication
public class HarjoitustyoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SushiRepository repository) {
		return (args) -> {
	 
			repository.save(new Sushi("sake", "salmon nigiri", 3.00));
			repository.save(new Sushi("tamago", "egg nigiri", 2.00));
			repository.save(new Sushi("ebi", "shrimp nigiri", 2.00));
			
		};
	}

}
