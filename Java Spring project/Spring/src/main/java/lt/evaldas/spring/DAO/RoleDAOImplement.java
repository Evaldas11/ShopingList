package lt.evaldas.spring.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.evaldas.spring.entities.Role;

@Repository
public class RoleDAOImplement implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Role> getRoles() {
		Session session = sessionFactory.getCurrentSession();
		List<Role> list = session.createQuery("FROM Role").getResultList();
		return list;
	}

	@Override
	public Role getRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.find(Role.class, id);
		return role;
	}

	@Override
	public void addRole(Role r) {
		Session session = sessionFactory.getCurrentSession();
		session.save(r);
	}

	@Override
	public void updateRole(Role r) {
		Session session = sessionFactory.getCurrentSession();
		session.update(r);
	}

}
