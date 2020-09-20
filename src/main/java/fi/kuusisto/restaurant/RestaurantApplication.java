package fi.kuusisto.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.kuusisto.restaurant.domain.Restaurant;
import fi.kuusisto.restaurant.domain.RestaurantRepository;

@SpringBootApplication
public class RestaurantApplication {
	private static final Logger log = LoggerFactory.getLogger(RestaurantApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
		
		@Bean
		public CommandLineRunner demo(RestaurantRepository repository) {
		return (args) -> {
			log.info("save some restaurants");
			repository.save(new Restaurant("Muru", "Fredrikinkatu 41", "0300472335"));
			repository.save(new Restaurant("Pizzeria Via Tribunali", "Sofiankatu 4", "0503288664"));
			repository.save(new Restaurant("Base Camp", "Yliopistonkatu 5", "0409643464"));
			
			log.info("find all restaurants");
			for (Restaurant restaurant : repository.findAll()) {
				log.info(restaurant.toString());
			}
		};
		
	}

}
