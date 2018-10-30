package lt.evaldas.spring.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.evaldas.spring.entities.ShopingShop;

@Repository
public class ShopingShopDAOImplement implements ShopingShopDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ShopingShop> getShops() {
		Session session = sessionFactory.getCurrentSession();
		List<ShopingShop> list = session.createQuery("FROM ShopingShop").getResultList();
		return list;
	}

	@Override
	public ShopingShop getShop(int id) {
		Session session = sessionFactory.getCurrentSession();
		ShopingShop shop = session.find(ShopingShop.class, id);
		return shop;
	}

	@Override
	public void addShop(ShopingShop s) {
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
	}

	@Override
	public void editShop(ShopingShop s) {
		Session session = sessionFactory.getCurrentSession();
		session.update(s);
	}

	@Override
	public void deleteShop(ShopingShop s) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(s);
	}
	
	

}
