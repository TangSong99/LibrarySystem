package cn.jmu.entity;

public class Reader {
	private String rnum;//���߱��
	private String cnum;//��λ���
	private String rolenum;//��ɫ��𣨶���/����Ա��
	private String rcnum;//��������ţ�ѧ��/�о���/��ʦ��
	private String rname;//����
	private boolean rsex;//�Ա�
	private String remail;//����
	private int rstate = 1;//״̬
	private int roverdue =0;//����
	private int rlevel;//Ȩ�޵ȼ�

	public String getRnum() {
		return rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getRolenum() {
		return rolenum;
	}

	public void setRolenum(String rolenum) {
		this.rolenum = rolenum;
	}

	public String getRcnum() {
		return rcnum;
	}

	public void setRcnum(String rcnum) {
		this.rcnum = rcnum;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public boolean isRsex() {
		return rsex;
	}

	public void setRsex(boolean rsex) {
		this.rsex = rsex;
	}

	public String getRemail() {
		return remail;
	}

	public void setRemail(String remail) {
		this.remail = remail;
	}

	public int getRstate() {
		return rstate;
	}

	public void setRstate(int rstate) {
		this.rstate = rstate;
	}

	public int getRoverdue() {
		return roverdue;
	}

	public void setRoverdue(int roverdue) {
		this.roverdue = roverdue;
	}

	public int getRlevel() {
		return rlevel;
	}

	public void setRlevel(int rlevel) {
		this.rlevel = rlevel;
	}

	@Override
	public String toString() {
		return "Reader{" +
				"rnum='" + rnum + '\'' +
				", cnum='" + cnum + '\'' +
				", rolenum='" + rolenum + '\'' +
				", rcnum='" + rcnum + '\'' +
				", rname='" + rname + '\'' +
				", rsex=" + rsex +
				", remail='" + remail + '\'' +
				", rstate=" + rstate +
				", roverdue=" + roverdue +
				", rlevel=" + rlevel +
				'}';
	}
}
