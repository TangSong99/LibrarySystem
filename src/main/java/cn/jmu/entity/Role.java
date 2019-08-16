package cn.jmu.entity;

public class Role {
	private String rolenum;//角色类别编号
	private String rolename;//角色类别名称

	public String getRolenum() {
		return rolenum;
	}

	public void setRolenum(String rolenum) {
		this.rolenum = rolenum;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public String toString() {
		return "Role{" +
				"rolenum='" + rolenum + '\'' +
				", rolename='" + rolename + '\'' +
				'}';
	}
}
