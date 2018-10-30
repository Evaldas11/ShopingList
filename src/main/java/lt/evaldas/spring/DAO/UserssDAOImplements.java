package lt.evaldas.spring.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lt.evaldas.spring.entities.Userss;

@Repository
public class UserssDAOImplements implements UserssDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Userss> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<Userss> list = session.createQuery("FROM Userss").getResultList();
		return list;
	}

	@Override
	public Userss getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Userss user = session.find(Userss.class, id);
		return user;
	}

	@Override
	public void addUser(Userss u) {
		Session session = sessionFactory.getCurrentSession();
		session.save(u);
	}

	@Override
	public void updateUser(Userss u) {
		Session session = sessionFactory.getCurrentSession();
		session.update(u);

	}

}
