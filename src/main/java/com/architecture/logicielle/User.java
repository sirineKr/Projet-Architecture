package com.architecture.logicielle;

import java.io.File;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")
@Entity // This tells Hibernate to make a table out of this class
public class User {
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String statut, String mail, Long id, String password, File photo) {
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
	@Column(name = "firstName")
    private String firstName;
	
	@NotNull
    @Size(min=2, max=30)
	@Column(name = "lastName")
    private String lastName;
	
	@NotNull
    @Size(min=2, max=30)
	@Column(name = "statut")
    private String statut;

    @NotNull
    @Column(name = "mail")
    private String mail;
    
    @Id
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "photo")
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
