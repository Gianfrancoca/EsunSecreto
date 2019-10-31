package pe.edu.upc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pe.edu.upc.model.Role;

@Entity
@Table(name="users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long idUser;
	
	@Column(name = "username", nullable = false, length = 30)
     private String username;
	
	@Column(name = "password", nullable = false, length = 30)
     private String password;
	
	@Enumerated(EnumType.STRING)
     private Role role;
     
     
     
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
