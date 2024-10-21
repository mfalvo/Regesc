package br.com.iconcourses.regesc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import br.com.iconcourses.regesc.model.Professor;
import br.com.iconcourses.regesc.repository.ProfessorRepository;

@SpringBootApplication
public class RegescApplication implements CommandLineRunner{
	
	public RegescApplication(ProfessorRepository repository) {
	}

	public static void main(String[] args) {
		SpringApplication.run(RegescApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		

	}

}
