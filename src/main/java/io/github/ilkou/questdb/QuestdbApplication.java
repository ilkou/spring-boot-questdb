package io.github.ilkou.questdb;

import io.github.ilkou.questdb.geoposition.GeoPosition;
import io.github.ilkou.questdb.geoposition.GeoPositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.Instant;


@SpringBootApplication
public class QuestdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestdbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(GeoPositionRepository geoPositionRepository) {
		return (args) -> {
			for (int i = 0; i < 1000; i++) {
				GeoPosition geoPosition = new GeoPosition(Timestamp.from(Instant.now()), "system", 40.7128, -74.0060, String.format("{\"idx\":%s}", i));
				geoPositionRepository.save(geoPosition);
			}
			System.out.println(geoPositionRepository.findAll());
		};
	}

}

