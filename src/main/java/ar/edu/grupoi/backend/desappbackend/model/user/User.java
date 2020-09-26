package ar.edu.grupoi.backend.desappbackend.model.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected String name;
	protected String mail;
	protected String password;

	public User() {}
	
	public User(String name, String mail, String password) {
		this.name = name;
		this.mail = mail;
		this.password = password;
	}

	public String getName() { return this.name; };
	public void setName(String name) { this.name = name; };
	public String getMail() { return this.mail; };
	public void setMail(String mail) { this.mail = mail; };
	public String getPassword() { return this.password; };
	public void setPassword(String password) { this.password = password; }
	public Integer getId() { return id; };
	public void setId(Integer id) {	this.id = id; };
	 	
}
