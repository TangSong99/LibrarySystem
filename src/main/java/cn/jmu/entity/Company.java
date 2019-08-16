package cn.jmu.entity;

public class Company {
	private String cnum;
	private String cname;
	private String ctel;

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	@Override
	public String toString() {
		return "Company{" +
				"cnum='" + cnum + '\'' +
				", cname='" + cname + '\'' +
				", ctel='" + ctel + '\'' +
				'}';
	}
}
