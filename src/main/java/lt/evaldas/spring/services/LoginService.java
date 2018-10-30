package lt.evaldas.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lt.evaldas.spring.DAO.*;
import lt.evaldas.spring.entities.Role;
import lt.evaldas.spring.entities.Userss;


@Service
public class LoginService {
	
	@Autowired
	private UserssDAO usersDAO;
	@Autowired
	private RoleDAO roleDAO;
	
	@Transactional
	public Userss getUser(int id) {
		Userss user = usersDAO.getUser(id);
		int size = user.getRoles().size();
		return user;	
	}
	
	@Transactional
	public List<Userss> getUsers(){
		return usersDAO.getUsers();
	}
	@Transactional
	public List<Role> getRoles(){
		return roleDAO.getRoles();
	}

}
