package lt.evaldas.spring.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Userss.findAll", query="SELECT u FROM Userss u")
public class Userss implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private byte enabled;

	private String password;

	private String username;

	@ManyToMany
	@JoinTable(
		name="authorities"
		, joinColumns={
			@JoinColumn(name="users_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="roles_id")
			}
		)
	private List<Role> roles;

	public Userss() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String toString() {
		return  "Username: "+username+", Email: "+email+", Enabled: "+enabled+ ". ";
	}

}