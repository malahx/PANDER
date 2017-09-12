/**
 * 
 */
package fr.redpanda.pander.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gwénolé LE HENAFF
 *
 */
@Controller
public class HomeWebCtrl {

	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
}
