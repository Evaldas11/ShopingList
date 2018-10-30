package lt.evaldas.spring.DAO;

import java.util.*;
import lt.evaldas.spring.entities.*;

public interface ShopingShopDAO {
	
	public List<ShopingShop> getShops();
	public ShopingShop getShop(int id);
	public void addShop(ShopingShop s);
	public void editShop(ShopingShop s);
	public void deleteShop(ShopingShop s);

}
