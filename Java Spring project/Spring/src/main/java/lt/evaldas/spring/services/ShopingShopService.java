package lt.evaldas.spring.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lt.evaldas.spring.DAO.*;
import lt.evaldas.spring.entities.*;

@Service
public class ShopingShopService {

	@Autowired
	private ShopingShopDAO ShopingShopDAO;
	
	@Transactional
	public List<ShopingShop> getShops(){	
		return ShopingShopDAO.getShops();
	}
	
	@Transactional
	public ShopingShop getShop(int id){	
		return ShopingShopDAO.getShop(id);
	}
	
	@Transactional
	public void addShop(ShopingShop s){	
		ShopingShopDAO.addShop(s);
	}
	
	@Transactional
	public void editShop(ShopingShop s){	
		ShopingShopDAO.editShop(s);
	}
	
	@Transactional
	public void deleteShop(ShopingShop deleteShop){		
		ShopingShopDAO.deleteShop(deleteShop);
	}
}
