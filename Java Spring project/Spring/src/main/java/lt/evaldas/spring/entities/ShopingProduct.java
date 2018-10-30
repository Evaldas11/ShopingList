package lt.evaldas.spring.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="shoping_products")
@NamedQuery(name="ShopingProduct.findAll", query="SELECT s FROM ShopingProduct s")
public class ShopingProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer amount;

	private String name;

	private String onPurchase;

	private Integer type;

	@ManyToOne
	@JoinColumn(name="shop_id")
	private ShopingShop shopingShop;

	public ShopingProduct() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnPurchase() {
		return this.onPurchase;
	}

	public void setOnPurchase(String onPurchase) {
		this.onPurchase = onPurchase;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ShopingShop getShopingShop() {
		return this.shopingShop;
	}

	public void setShopingShop(ShopingShop shopingShop) {
		this.shopingShop = shopingShop;
	}
	public String getDisplayType() {
		if(this.type == 0) {
			return "Maisto prekes";
		}else if(this.type == 1) {
			return "Buitines prekes";
		} else if(this.type == 2) {
			return "Technika";
		}else {
			return "Nezinoma rusis";
		}
		
	}

}