package lt.evaldas.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lt.evaldas.spring.services.LoginService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public String admin(Model model) {
		model.addAttribute("usersList", loginService.getUsers());
		return "admin";
	}
	
	@GetMapping("/roles")
	public String roles(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("user", loginService.getUser(id));
		model.addAttribute("rolesList", loginService.getUser(id).getRoles());
		model.addAttribute("roles", loginService.getRoles());
		return "roles";
	}
	
	@PostMapping("/roles")
	public String AddRole( @RequestParam("userId") Integer userId, @RequestParam("roleId") Integer roleId) {
		
		
		
		return "redirect:/admin/";
	}
	
}
