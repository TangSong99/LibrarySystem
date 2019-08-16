package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 22:24
 */
public class BorrowRequire {
    private String rcnum;
    private String btnum;
    private int brnum;//可借数
    private String brdate;//可借天数
    private String brrenew;//可续借天数

    public String getRcnum() {
        return rcnum;
    }

    public void setRcnum(String rcnum) {
        this.rcnum = rcnum;
    }

    public String getBtnum() {
        return btnum;
    }

    public void setBtnum(String btnum) {
        this.btnum = btnum;
    }

    public int getBrnum() {
        return brnum;
    }

    public void setBrnum(int brnum) {
        this.brnum = brnum;
    }

    public String getBrdate() {
        return brdate;
    }

    public void setBrdate(String brdate) {
        this.brdate = brdate;
    }

    public String getBrrenew() {
        return brrenew;
    }

    public void setBrrenew(String brrenew) {
        this.brrenew = brrenew;
    }

    @Override
    public String toString() {
        return "BorrowRequire{" +
                "rcnum='" + rcnum + '\'' +
                ", btnum='" + btnum + '\'' +
                ", brnum=" + brnum +
                ", brdate='" + brdate + '\'' +
                ", brrenew='" + brrenew + '\'' +
                '}';
    }
}
