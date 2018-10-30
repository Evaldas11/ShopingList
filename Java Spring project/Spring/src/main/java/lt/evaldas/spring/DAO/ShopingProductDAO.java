package lt.evaldas.spring.DAO;
import java.util.*;
import lt.evaldas.spring.entities.*;

public interface ShopingProductDAO {
	
	public List<ShopingProduct> getProducts();
	public ShopingProduct getProduct(int id);
	public void addProduct(ShopingProduct p);
	public void editProduct(ShopingProduct p);
	public void deleteProduct(ShopingProduct p);
	public List<ShopingProduct> getUnPurchaseProducts();
	public List<ShopingProduct> getPurchaseProducts();
	
	
}
