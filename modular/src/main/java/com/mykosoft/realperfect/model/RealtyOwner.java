package com.mykosoft.realperfect.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_realty_owner")
public class RealtyOwner {
	private Long id;
	
	private User user;
	
//	private Set<RealtyObject> realtyObjects;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
//	public Set<RealtyObject> getRealtyObjects() {
//		return realtyObjects;
//	}
//	public void setRealtyObjects(Set<RealtyObject> realtyObjects) {
//		this.realtyObjects = realtyObjects;
//	}
}