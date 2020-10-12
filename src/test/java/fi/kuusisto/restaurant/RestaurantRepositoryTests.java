package fi.kuusisto.restaurant;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.kuusisto.restaurant.domain.Cuisine;
import fi.kuusisto.restaurant.domain.Restaurant;
import fi.kuusisto.restaurant.domain.RestaurantRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestaurantRepositoryTests {
	
	@Autowired
	private RestaurantRepository repository;
	
	@Test
	public void findByNameShouldReturnRestaurant() {
		List<Restaurant> restaurants = repository.findByAddress("Fredrikinkatu 41");
		assertThat(restaurants).hasSize(1);
		assertThat(restaurants.get(0).getName()).isEqualTo("Muru");	
	}
	
	@Test
	public void createNewRestaurant() {
		Restaurant restaurant = new Restaurant("Maya Bar & Grill", "Mikonkatu 18", "09666554", new Cuisine("Meksikolainen"));
		repository.save(restaurant);
		assertThat(restaurant.getId()).isNotNull();
	}

}
