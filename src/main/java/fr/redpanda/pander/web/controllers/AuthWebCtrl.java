/**
 * 
 */
package fr.redpanda.pander.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gwénolé LE HENAFF
 *
 */
@Controller
public class AuthWebCtrl {

	@GetMapping("/auth")
	public String auth() {
		return "auth";
	}
}
