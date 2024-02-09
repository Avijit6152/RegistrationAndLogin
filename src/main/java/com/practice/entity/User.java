package com.practice.entity;

import java.util.Collection;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name="user" , uniqueConstraints = @UniqueConstraint(columnNames = "uemail"))
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GenericGenerator(name = "auto",strategy = "increment")
//	@GeneratedValue(generator = "auto")
	private int uid;
	private String uname;
	private String uemail;
	private String upassword;
	
	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinTable(
			
			
			
			   name="users_roles" , joinColumns = @JoinColumn(name="user_uid",referencedColumnName = "uid"),
			   inverseJoinColumns = @JoinColumn(name="role_rid",referencedColumnName = "rid")
			   
			   
			
			)
	private Collection<Role> roles;
	
	
	public User() {}
	
	public User(String uname, String uemail, String upassword, Collection<Role> roles) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.roles = roles;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	

}
