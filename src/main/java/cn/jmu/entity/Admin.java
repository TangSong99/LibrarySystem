package cn.jmu.entity;

public class Admin {
    private String lnum;
    private String rolenum;
    private String lname;
    private boolean lsex;
    private String lemail;
    private int lstate;
    private int llevel;

    public String getLnum() {
        return lnum;
    }

    public void setLnum(String lnum) {
        this.lnum = lnum;
    }

    public String getRolenum() {
        return rolenum;
    }

    public void setRolenum(String rolenum) {
        this.rolenum = rolenum;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public boolean isLsex() {
        return lsex;
    }

    public void setLsex(boolean lsex) {
        this.lsex = lsex;
    }

    public String getLemail() {
        return lemail;
    }

    public void setLemail(String lemail) {
        this.lemail = lemail;
    }

    public int getLstate() {
        return lstate;
    }

    public void setLstate(int lstate) {
        this.lstate = lstate;
    }

    public int getLlevel() {
        return llevel;
    }

    public void setLlevel(int llevel) {
        this.llevel = llevel;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "lnum='" + lnum + '\'' +
                ", rolenum='" + rolenum + '\'' +
                ", lname='" + lname + '\'' +
                ", lsex=" + lsex +
                ", lemail='" + lemail + '\'' +
                ", lstate=" + lstate +
                ", llevel=" + llevel +
                '}';
    }
}
