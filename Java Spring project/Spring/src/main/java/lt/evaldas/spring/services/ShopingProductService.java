package lt.evaldas.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lt.evaldas.spring.DAO.*;
import lt.evaldas.spring.entities.ShopingProduct;

@Service
public class ShopingProductService {

	@Autowired
	private ShopingProductDAO ShopingProductDAO;
	@Autowired
	private ShopingShopDAO ShopingShopDAO;
	
	@Transactional
	public List<ShopingProduct> getProducts(){
		return ShopingProductDAO.getProducts();
	}
	@Transactional
	public ShopingProduct getProduct(int id) {
		return ShopingProductDAO.getProduct(id);
	}
	@Transactional
	public void addProduct(ShopingProduct newProduct, Integer id) {
		newProduct.setShopingShop(ShopingShopDAO.getShop(id));
		newProduct.setOnPurchase("0");
		ShopingProductDAO.addProduct(newProduct);
	}
	@Transactional
	public void editProduct(ShopingProduct p) {
		ShopingProductDAO.editProduct(p);
	}
	@Transactional
	public void deleteProduct(ShopingProduct p) {
		ShopingProductDAO.deleteProduct(p);
	}
	
	@Transactional
	public List<ShopingProduct> getUnPurchaseProducts() {
		return ShopingProductDAO.getUnPurchaseProducts();
	}
	
	@Transactional
	public List<ShopingProduct> getPurchaseProducts(){
		return ShopingProductDAO.getPurchaseProducts();
	}
	
}
