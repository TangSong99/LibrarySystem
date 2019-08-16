package cn.jmu.entity;

public class ReaderClass {
	private String rcnum;//读者类别编号
	private String rcname;//读者类别名称
	private int maxnum;//最大借阅数量

	public String getRcnum() {
		return rcnum;
	}

	public void setRcnum(String rcnum) {
		this.rcnum = rcnum;
	}

	public String getRcname() {
		return rcname;
	}

	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	public int getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}

	@Override
	public String toString() {
		return "ReaderClass{" +
				"rcnum='" + rcnum + '\'' +
				", rcname='" + rcname + '\'' +
				", maxnum=" + maxnum +
				'}';
	}
}
