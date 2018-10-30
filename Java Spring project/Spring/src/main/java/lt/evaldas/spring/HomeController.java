package lt.evaldas.spring;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lt.evaldas.spring.services.*;
import lt.evaldas.spring.entities.*;


@Controller 
public class HomeController {
	
	@Autowired
	private ShopingShopService  ShopingShopService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
	StringTrimmerEditor stEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stEditor);
	}
	
	@GetMapping("/")
	public String dashboard(Model model) {
		
		return "dashboard";
	}
	
	@GetMapping("/shops")
	public String shops(Model model) {
		model.addAttribute("shops", ShopingShopService.getShops());
		return "shops";
	}
	
	@GetMapping("/shops/addNew")
	public String addNewShop(Model model) {
		ShopingShop shop = new ShopingShop();
		model.addAttribute("shop", shop);
		return "addNewShop";
	}
	
	@PostMapping("/shops/addNew")
	public String saveShop(@Valid @ModelAttribute("shop") ShopingShop newShop, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "redirect:/shops/addNew";
		}else {
			ShopingShopService.addShop(newShop);
			return "redirect:/shops";
		}
		
	}
	
	@GetMapping("/shops/delete")
	public String deleteShop(@RequestParam("id") Integer id) {
		ShopingShop deleteShop = ShopingShopService.getShop(id);
		ShopingShopService.deleteShop(deleteShop);
		return "redirect:/shops";
	}
	
	@GetMapping("/shops/edit")
	public String editShop(@RequestParam("id") Integer id, Model model) {
		ShopingShop editShop = ShopingShopService.getShop(id);
		model.addAttribute("editShop",editShop);
		return "editShop";
	}
	
	@PostMapping("/shops/edit")
	public String updateShop(@ModelAttribute("editShop") ShopingShop updateShop, Model model) {
		ShopingShopService.editShop(updateShop);
		return "redirect:/shops";
	}
	
	
	
	
	
}
