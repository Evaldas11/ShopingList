package lt.evaldas.spring;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.evaldas.spring.entities.ShopingProduct;
import lt.evaldas.spring.entities.ShopingShop;
import lt.evaldas.spring.services.*;

@Controller
public class ProductsController {

	@Autowired
	private ShopingProductService  ShopingProductService;
	@Autowired
	private ShopingShopService  ShopingShopService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
	StringTrimmerEditor stEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stEditor);
	}
	
	@GetMapping("/products")
	public String products(Model model) {
		model.addAttribute("unPurchaseProducts", ShopingProductService.getUnPurchaseProducts());
		model.addAttribute("shops", ShopingShopService.getShops());
		return "products";
	}
	
	@GetMapping("/products/selected")
	public String selectedShop(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("shops", ShopingShopService.getShops());
		
		List<ShopingProduct> list = ShopingShopService.getShop(id).getShopingProducts();
		List<ShopingProduct> unPurchaseProducts = new LinkedList<>();
		for(ShopingProduct s: list) {
			if(s.getOnPurchase().equals("0")) {
				unPurchaseProducts.add(s);
			}
		}
		model.addAttribute("unPurchaseProducts", unPurchaseProducts);	
		
//		model.addAttribute("unPurchaseProducts", ShopingShopService.getShop(id).getShopingProducts());
		return "products";
	}
	
	@GetMapping("/products/purchase")
	public String purchaseProduct(@RequestParam("id") Integer id) {
		ShopingProduct purchaseProduct = ShopingProductService.getProduct(id);
		purchaseProduct.setOnPurchase("2018.10.18");
		ShopingProductService.editProduct(purchaseProduct);
		return "redirect:/products";
	}
	
	@GetMapping("/products/delete")
	public String deleteProduct(@RequestParam("id") Integer id) {
		ShopingProductService.deleteProduct(ShopingProductService.getProduct(id));
		return "redirect:/products";
	}
	
	@GetMapping("/shopingHistory")
	public String shopingHistory(Model model) {
		model.addAttribute("shops", ShopingShopService.getShops());
		model.addAttribute("purchaseProducts", ShopingProductService.getPurchaseProducts());
		return "shopingHistory";
	}
	
	@GetMapping("products/addNewProduct")
	public String addProduct(Model model) {
		ShopingProduct newProduct = new ShopingProduct();
		model.addAttribute("newProduct", newProduct);
		model.addAttribute("shopsList", ShopingShopService.getShops());
		return "addNewProduct";
	}
	
	@PostMapping("products/addNewProduct")
	public String addProduct(@ModelAttribute("newProduct") ShopingProduct newProduct, @RequestParam("shopId") Integer id) {
		ShopingProductService.addProduct(newProduct, id);
		return "redirect:/products";
	}
	
	@GetMapping("/shopingHistory/selected")
	public String selectShop(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("shops", ShopingShopService.getShops());
		
		List<ShopingProduct> list  =  ShopingShopService.getShop(id).getShopingProducts();
		List<ShopingProduct> purchaseProducts = new LinkedList<>();
		for(ShopingProduct s: list) {
			if(!s.getOnPurchase().equals("0")) {
				purchaseProducts.add(s);
			}
		}
		model.addAttribute("purchaseProducts", purchaseProducts);	
		
//		model.addAttribute("purchaseProducts", ShopingShopService.getShop(id).getShopingProducts());
		return "shopingHistory";
	}
	
	
	
	
	
}
