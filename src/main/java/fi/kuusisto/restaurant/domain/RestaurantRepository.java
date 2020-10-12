package fi.kuusisto.restaurant.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

	List<Restaurant> findByAddress(String address);
}
