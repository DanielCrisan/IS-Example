package com.lab_IS.resurse_lab;

import com.lab_IS.resurse_lab.models.*;
import com.lab_IS.resurse_lab.repositories.ComponentaRepository;
import com.lab_IS.resurse_lab.repositories.MasinaRepository;
import com.lab_IS.resurse_lab.repositories.ProprietarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class ResurseLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResurseLabApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MasinaRepository masinaRepository, ComponentaRepository componentaRepository, ProprietarRepository proprietarRepository) {
		return args -> {
			Roata componenta1 = new Roata(30L);
			Claxon componenta2 = new Claxon("rosu");
			ArrayList<Componenta> componente = new ArrayList<>();
			componente.add(componenta1);
			componente.add(componenta2);
			componentaRepository.saveAll(componente);

			Masina masina1 = new Masina(null, "BEMBEU", null, null);
			Masina masina2 = new Masina(null, "BEMBEU2", null, null);
			ArrayList<Masina> masini = new ArrayList<>();
			masini.add(masina1);
			masini.add(masina2);
			masinaRepository.saveAll(masini);

			Proprietar proprietar = new Proprietar(null, "Mititelu", masini);
			Proprietar proprietarSaved = proprietarRepository.save(proprietar);

			masina1.setProprietar(proprietarSaved);
			masinaRepository.save(masina1);

			masinaRepository.findById(3L).ifPresent(masina3 -> {
				System.out.println(masina3.getProprietar().getMasini().get(0).getProprietar());
			});

//			masinaRepository.delete(masinaSaved);
		};
	}
}
