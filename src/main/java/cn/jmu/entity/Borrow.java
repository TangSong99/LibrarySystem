package cn.jmu.entity;

import java.util.Date;

/**
 * @author CTX
 * @since 2019/7/6 02:26
 */
public class Borrow {
    private String rnum;//读者编号
    private String bnum;//图书编号
    private String snum;//学期编号
    private Date bdate;//借书日期
    private Date edate;//应还书日期
    private int restate;//续借状态
    private int brstate;

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getBnum() {
        return bnum;
    }

    public void setBnum(String bnum) {
        this.bnum = bnum;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public int getRestate() {
        return restate;
    }

    public void setRestate(int restate) {
        this.restate = restate;
    }

    public int getBrstate() {
        return brstate;
    }

    public void setBrstate(int brstate) {
        this.brstate = brstate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "rnum='" + rnum + '\'' +
                ", bnum='" + bnum + '\'' +
                ", snum='" + snum + '\'' +
                ", bdate=" + bdate +
                ", edate=" + edate +
                ", restate=" + restate +
                ", brstate=" + brstate +
                '}';
    }
}
