/**
 * 
 */
package fr.redpanda.pander.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.redpanda.pander.databases.UserDAO;
import fr.redpanda.pander.entities.User;

/**
 * @author Gwénolé LE HENAFF
 *
 */
@Controller
public class AuthWebCtrl {

	@GetMapping("/auth")
	public String auth(Model model) {
		return "auth";
	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true) String password) {
		User user = (User) UserDAO.getInstance().get(email, password);
		if (user != null) {
			return "redirect:/home";
		}
		return "auth";
	}
	
}
