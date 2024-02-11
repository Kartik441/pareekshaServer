package com.pareeksha.pareekshaServer.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "roles")
public class Role {

	@Id
	private Long roleId;
	private String roleName;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="role")
	@JsonIgnore
	private Set<UserRole> userRole = new HashSet<>();


	public Role() {}
	public Role(Long roleId, String role, Set<UserRole> userRole) {
		super();
		this.roleId = roleId;
		this.roleName = role;
		this.userRole = userRole;
	}
	
	public Role(Long roleId, String role) {
		super();
		this.roleId = roleId;
		this.roleName = role;
	}
	
	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String role) {
		this.roleName = role;
	}


	public Set<UserRole> getUserRole() {
		return userRole;
	}


	public void setUserRole(HashSet<UserRole> userRole) {
		this.userRole = userRole;
	}


}
