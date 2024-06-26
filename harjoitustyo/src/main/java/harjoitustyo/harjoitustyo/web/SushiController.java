package harjoitustyo.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import harjoitustyo.harjoitustyo.domain.CategoryRepository;
import harjoitustyo.harjoitustyo.domain.Sushi;
import harjoitustyo.harjoitustyo.domain.SushiRepository;

@Controller
public class SushiController {
	
	@Autowired
	private SushiRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value="/sushilist")
	public String showSushis(Model model) {
		model.addAttribute("sushis", repository.findAll());
		return "sushilist";
	}
	
	@GetMapping(value="/add")
	public String addSushi(Model model) {
		model.addAttribute("sushi", new Sushi());
		model.addAttribute("categories", crepository.findAll()); //
		return "addsushi";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Sushi sushi) {
		repository.save(sushi);
		return "redirect:/sushilist";
	}
	
	@GetMapping("/edit/{id}")
	public String editSushi(@PathVariable("id") Long id, Model model) {
		Sushi originalSushi = repository.findById(id).orElse(null);
		if(originalSushi != null) {
			model.addAttribute("sushi", originalSushi);
			model.addAttribute("categories", crepository.findAll());
			return "editsushi";
		}else {
			return "redirect:/sushilist";
		}
		
		
	}
	
	@PostMapping(value="/update/{id}")
	public String updateSushi(Sushi sushi) {
		repository.save(sushi);
		return "redirect:/sushilist";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteSushi(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:../sushilist";
	}

}
