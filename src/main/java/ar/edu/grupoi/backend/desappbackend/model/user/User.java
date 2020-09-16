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

	public abstract String getName();
	public abstract void setName(String name);
	public abstract String getMail();
	public abstract void setMail(String mail);
	public abstract String getPassword();
	public abstract void setPassword(String password);
	 	
}
