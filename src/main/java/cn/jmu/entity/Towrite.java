package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 21:40
 */
public class Towrite {
    private String bnum;
    private int anum;
    private String rolename;//主编、翻译

    public String getBnum() {
        return bnum;
    }

    public void setBnum(String bnum) {
        this.bnum = bnum;
    }

    public int getAnum() {
        return anum;
    }

    public void setAnum(int anum) {
        this.anum = anum;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Towrite{" +
                "bnum='" + bnum + '\'' +
                ", anum='" + anum + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
