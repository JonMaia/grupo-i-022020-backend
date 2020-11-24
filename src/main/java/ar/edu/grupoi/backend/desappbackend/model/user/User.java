package ar.edu.grupoi.backend.desappbackend.model.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
@SequenceGenerator(name="seq", initialValue=4, allocationSize=100)
public abstract class User  {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq")
	protected Integer id;
	@NotBlank(message = "Name is mandatory")
	@Size(min = 5, max = 10)
	protected String name;
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Enter a correct email")
	protected String mail;
	@NotBlank(message = "Password is mandatory")
	@Size(min = 5, max = 8)
	protected String password;
	
	protected String token;

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
	public Integer getId() { return id; }
	public String getToken() { return token; }
	public void setToken(String token) { this.token = token; };
	
	 	
}
