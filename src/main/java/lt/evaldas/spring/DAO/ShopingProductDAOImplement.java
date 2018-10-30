package lt.evaldas.spring.DAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import lt.evaldas.spring.entities.*;


@Repository
public class ShopingProductDAOImplement implements ShopingProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ShopingProduct> getProducts() {
		Session session = sessionFactory.getCurrentSession();
		List<ShopingProduct> list = session.createQuery("FROM ShopingProduct").list();
		return list;
	}

	@Override
	public ShopingProduct getProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		ShopingProduct product = session.find(ShopingProduct.class, id);
		return product;
	}

	@Override
	public void editProduct(ShopingProduct p) {
		Session session = sessionFactory.getCurrentSession();
		session.update(p);
	}

	@Override
	public void deleteProduct(ShopingProduct p) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(p);
	}

	@Override
	public void addProduct(ShopingProduct p) {
		Session session = sessionFactory.getCurrentSession();
		session.save(p);
	}

	@Override
	public List<ShopingProduct> getUnPurchaseProducts() {
		Session session = sessionFactory.getCurrentSession();
		List<ShopingProduct> list = session.createQuery("FROM ShopingProduct WHERE onPurchase=0").getResultList();
		return list;
	}

	@Override
	public List<ShopingProduct> getPurchaseProducts() {
		Session session = sessionFactory.getCurrentSession();
		List<ShopingProduct> list = session.createQuery("FROM ShopingProduct WHERE onPurchase!=0").getResultList();
		return list;
	}

}
