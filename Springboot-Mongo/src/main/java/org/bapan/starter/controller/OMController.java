/**
 * 
 */
package org.bapan.starter.controller;

import java.util.List;

import org.bapan.starter.entity.User;
import org.bapan.starter.respository.OrderReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ruptam
 *
 */
@RestController
public class OMController {
	
	@Autowired
	private OrderReository orderRepository;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@RequestBody User user) {
		orderRepository.save(user);
		return "User saved successfully...";
	}
	@RequestMapping(value="/userByName/{byName}",method=RequestMethod.GET)
	public List<User> getUserByName(@PathVariable("byName") String name) {
		System.out.println("User Name " + name);
		return orderRepository.findByName(name);
	}
	@RequestMapping(value="/userByAddress/{byCity}",method=RequestMethod.GET)
	public List<User> getUserByAddress(@PathVariable("byCity") String city) {
		System.out.println("City Name " +city);
		return orderRepository.findByCity(city);
	}
}
