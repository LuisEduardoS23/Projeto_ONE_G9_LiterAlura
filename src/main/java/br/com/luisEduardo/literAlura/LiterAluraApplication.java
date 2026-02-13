package br.com.luisEduardo.literAlura;

import br.com.luisEduardo.literAlura.principal.Principal;
import br.com.luisEduardo.literAlura.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private final LivroService livroService;

	public LiterAluraApplication(LivroService livroService) {
		this.livroService = livroService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(livroService);
		principal.menu();

	}
}
