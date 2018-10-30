package lt.evaldas.spring.DAO;

import lt.evaldas.spring.entities.*;
import java.util.*;

public interface RoleDAO {
	
	public List<Role> getRoles();
	public Role getRole(int id);
	public void addRole(Role r);
	public void updateRole(Role r);

}
