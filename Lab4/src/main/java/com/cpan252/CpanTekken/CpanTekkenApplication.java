package com.cpan252.CpanTekken;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.cpan252.CpanTekken.model.Fighter;
import com.cpan252.CpanTekken.model.Fighter.Anime;
import com.cpan252.CpanTekken.repository.FighterRepository;

@SpringBootApplication
public class CpanTekkenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CpanTekkenApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(FighterRepository repository) {
		return args -> {
			repository.save(Fighter.builder()
			.name("Random Fighter")
			.animeFrom(Anime.NARUTO)
			.damagePerHit(89)
			.health(2500)
			.resistance(new BigDecimal(0.9)).build());

			repository.save(Fighter.builder()
			.name("George Walker")
			.animeFrom(Anime.TEKKEN)
			.damagePerHit(56)
			.health(2200)
			.resistance(new BigDecimal(0.6)).build());

			repository.save(Fighter.builder()
			.name("Naruto Uzumaki")
			.animeFrom(Anime.NARUTO)
			.damagePerHit(90)
			.health(2200)
			.resistance(new BigDecimal(0.5)).build());
			
			repository.save(Fighter.builder()
			.name("Tekken Guy")
			.animeFrom(Anime.TEKKEN)
			.damagePerHit(85)
			.health(21000)
			.resistance(new BigDecimal(0.7)).build());
		};
	}

}
