package fi.kuusisto.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.kuusisto.restaurant.domain.Restaurant;
import fi.kuusisto.restaurant.domain.RestaurantRepository;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository repository;
	
	@RequestMapping("/restaurantlist")
	public String restaurantList(Model model) {
		model.addAttribute("restaurants", repository.findAll());
		return "restaurantlist";
	}
	
	@RequestMapping(value = "/add")
	public String addRestaurant(Model model) {
		model.addAttribute("restaurant", new Restaurant());
		return "addrestaurant";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Restaurant restaurant) {
		repository.save(restaurant);
		return "redirect:restaurantlist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteRestaurant(@PathVariable("id") Long restaurantId, Model model) {
		repository.deleteById(restaurantId);
		return "redirect:../restaurantlist";
	}

}
