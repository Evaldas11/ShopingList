package lt.evaldas.spring.DAO;
import java.util.List;

import lt.evaldas.spring.entities.*;

public interface UserssDAO {
	
	public List<Userss> getUsers();
	public Userss getUser(int id);
	public void addUser(Userss u);
	public void updateUser(Userss u);

}
