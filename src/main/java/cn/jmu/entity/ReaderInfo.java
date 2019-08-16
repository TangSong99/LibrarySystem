package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/7 16:53
 */
public class ReaderInfo {
    private String rnum;//读者编号
    private String cnum;//单位编号
    private String cname;
    private String ctel;
    private String rolenum;//角色类别（读者/管理员）
    private String rolename;
    private String usernum;
    private String userpwd;
    private String rcnum;//读者类别编号（学生/研究生/教师）
    private String rcname;
    private int maxnum;
    private String rname;//姓名
    private boolean rsex;//性别
    private String remail;//邮箱
    private int rstate = 1;//状态
    private int roverdue =0;//逾期
    private int rlevel;//权限等级

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

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

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
        return "ReaderInfo{" +
                "rnum='" + rnum + '\'' +
                ", cnum='" + cnum + '\'' +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", rolenum='" + rolenum + '\'' +
                ", rolename='" + rolename + '\'' +
                ", usernum='" + usernum + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", rcnum='" + rcnum + '\'' +
                ", rcname='" + rcname + '\'' +
                ", maxnum=" + maxnum +
                ", rname='" + rname + '\'' +
                ", rsex=" + rsex +
                ", remail='" + remail + '\'' +
                ", rstate=" + rstate +
                ", roverdue=" + roverdue +
                ", rlevel=" + rlevel +
                '}';
    }
}
