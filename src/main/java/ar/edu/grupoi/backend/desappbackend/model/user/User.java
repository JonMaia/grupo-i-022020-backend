package ar.edu.grupoi.backend.desappbackend.model.user;

public abstract class User {
	
	protected String name;
	protected String mail;
	protected String password;

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
	public void setPassword(String password) { this.password = password; };
	 	
}
