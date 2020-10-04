package fi.kuusisto.restaurant.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.kuusisto.restaurant.domain.CuisineRepository;
import fi.kuusisto.restaurant.domain.Restaurant;
import fi.kuusisto.restaurant.domain.RestaurantRepository;

@Controller
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository repository;
	
	@Autowired
	private CuisineRepository crepository;
	
	
	//Kirjautumissivu
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	} 
	
	//Näyttää kaikki ravintolat
	@RequestMapping("/restaurantlist")
	public String restaurantList(Model model) {
		model.addAttribute("restaurants", repository.findAll());
		return "restaurantlist";
	}
	
	//Lisää ravintola
	@RequestMapping(value = "/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addRestaurant(Model model) {
		model.addAttribute("restaurant", new Restaurant());
		model.addAttribute("cuisines", crepository.findAll());
		return "addRestaurant";
	}
	
	//Tallentaa uuden ravintolan
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Restaurant restaurant) {
		repository.save(restaurant);
		return "redirect:restaurantlist";
	}
	
	//Poistaa ravintolan
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteRestaurant(@PathVariable("id") Long restaurantId, Model model) {
		repository.deleteById(restaurantId);
		return "redirect:../restaurantlist";
	}
	
	//Muokkaa ravintolan tietoja
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editRestaurant(@PathVariable("id") Long restaurantId, Model model) {
		model.addAttribute("restaurant", repository.findById(restaurantId));
		model.addAttribute("cuisines", crepository.findAll());
		return "editRestaurant";
	}
	
	//REST, jolla haetaan kaikki ravintolat
	@RequestMapping(value="/restaurants", method = RequestMethod.GET)
	public @ResponseBody List<Restaurant> restaurantListRest() {
		return (List<Restaurant>) repository.findAll();
	}
	
	//REST, jolla haetaan ravintola id:n perusteella
	@RequestMapping(value="/restaurant/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Restaurant> findRestaurantRest(@PathVariable("id") Long restaurantId) {
	 return repository.findById(restaurantId);
	}

}
