package cn.jmu.entity;

public class User {
	private String usernum;//用户号
	private String rolenum;//用户角色编号
	private String userpwd;//用户密码

	public String getUsernum() {
		return usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}

	public String getRolenum() {
		return rolenum;
	}

	public void setRolenum(String rolenum) {
		this.rolenum = rolenum;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String toString() {
		return "User{" +
				"usernum='" + usernum + '\'' +
				", rolenum='" + rolenum + '\'' +
				", userpwd='" + userpwd + '\'' +
				'}';
	}
}
