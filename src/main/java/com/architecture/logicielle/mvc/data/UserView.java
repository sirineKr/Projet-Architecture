package com.architecture.logicielle.mvc.data;

import java.io.File;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class UserView {
	
	public UserView() {
		
	}
	
	public UserView(UserView usr1, UserView usr2) {
		usr1.firstName = usr2.firstName;
		usr1.lastName = usr2.lastName;
		usr1.statut = usr2.statut;
		usr1.mail = usr2.mail;
		usr1.id = usr2.id;
		usr1.password = usr2.password;
		usr1.photo = usr2.photo;
	}

	public UserView(String firstName, String lastName, String statut, String mail, Long id, String password, File photo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.statut = statut;
		this.mail = mail;
		this.id = id;
		this.password = password;
		this.photo = photo;
	}

	@NotNull
    @Size(min=2, max=30)
    private String firstName;
	
	@NotNull
    @Size(min=2, max=30)
    private String lastName;
	
	@NotNull
    @Size(min=2, max=30)
    private String statut;

    @NotNull
    private String mail;
    
    @Id
    private Long id;
    
    @NotNull
    private String password;

    @NotNull
    private File photo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
