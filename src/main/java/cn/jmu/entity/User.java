package cn.jmu.entity;

public class User {
	private String usernum;//�û���
	private String rolenum;//�û���ɫ���
	private String userpwd;//�û�����

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
