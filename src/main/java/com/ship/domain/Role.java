package com.ship.domain;

import com.ship.domain.Role.USER_ROLE;

public class Role {
	private String roleId;
	private USER_ROLE roleName;

	public enum USER_ROLE{
		SHOP, SHIPER, MAMAGER
		}
	public Role(String roleId, USER_ROLE roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public USER_ROLE getRoleName() {
		return roleName;
	}

	public void setRoleName(USER_ROLE roleName) {
		this.roleName = roleName;
	}
	
	public static USER_ROLE getRole(String role){
		if (USER_ROLE.MAMAGER.equals(role))
			return USER_ROLE.MAMAGER;
		if (USER_ROLE.SHOP.equals(role))
			return USER_ROLE.SHOP;
		if (USER_ROLE.SHIPER.equals(role))
			return USER_ROLE.SHIPER;
		return USER_ROLE.SHIPER;
	}


}
