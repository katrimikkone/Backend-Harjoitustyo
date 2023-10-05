package harjoitustyo.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harjoitustyo.harjoitustyo.domain.AppUser;
import harjoitustyo.harjoitustyo.domain.AppUserRepository;
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
	public CommandLineRunner demo(SushiRepository repository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("maki"));
			crepository.save(new Category("nigiri"));
			crepository.save(new Category("sashimi"));
			crepository.save(new Category("temaki"));
			
			repository.save(new Sushi("sake", "salmon", 3.00, crepository.findByName("maki").get(0)));
			repository.save(new Sushi("tamago", "egg", 2.00, crepository.findByName("nigiri").get(0)));
			repository.save(new Sushi("ebi", "shrimp", 2.00, crepository.findByName("nigiri").get(0)));
			
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN" );
			urepository.save(user1);
			urepository.save(user2);
		};
	}

}
