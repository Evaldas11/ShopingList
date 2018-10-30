package lt.evaldas.spring.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.*;

@Entity
@Table(name="shoping_shops")
@NamedQuery(name="ShopingShop.findAll", query="SELECT s FROM ShopingShop s")
public class ShopingShop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(min=10, message="Adresas turi sudaryti minimum is 6 simboliu !")
	private String address;
	
	@Size(min=3, message="Varda turi sudaryti minimum 3 simboliai !")
	private String name;

	@OneToMany(mappedBy="shopingShop", fetch=FetchType.EAGER)
	private List<ShopingProduct> shopingProducts;

	public ShopingShop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ShopingProduct> getShopingProducts() {
		return this.shopingProducts;
	}

	public void setShopingProducts(List<ShopingProduct> shopingProducts) {
		this.shopingProducts = shopingProducts;
	}

	public ShopingProduct addShopingProduct(ShopingProduct shopingProduct) {
		getShopingProducts().add(shopingProduct);
		shopingProduct.setShopingShop(this);
		return shopingProduct;
	}

	public ShopingProduct removeShopingProduct(ShopingProduct shopingProduct) {
		getShopingProducts().remove(shopingProduct);
		shopingProduct.setShopingShop(null);
		return shopingProduct;
	}

}