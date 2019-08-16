package cn.jmu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author CTX
 * @since 2019/7/9 15:18
 */
public class BorrowInfo {
    private String bnum;
    private String bname;
    private String collectionnum;
    private int bstate;
    private String blnum;

    public String getBlname() {
        return blname;
    }

    public void setBlname(String blname) {
        this.blname = blname;
    }

    private String blname;

    private String snum;//学期编号
    private Date bdate;//借书日期
    private Date edate;//应还书日期
    private Boolean restate;//续借状态

    private String rnum;//读者编号
    private String rname;

    private Double rfmoney;
    private String reason;

    public int getBrstate() {
        return brstate;
    }

    public void setBrstate(int brstate) {
        this.brstate = brstate;
    }

    private int brstate;

    public Double getRfmoney() {
        return rfmoney;
    }

    public void setRfmoney(Double rfmoney) {
        this.rfmoney = rfmoney;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBnum() {
        return bnum;
    }

    public void setBnum(String bnum) {
        this.bnum = bnum;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(String collectionnum) {
        this.collectionnum = collectionnum;
    }

    public int getBstate() {
        return bstate;
    }

    public void setBstate(int bstate) {
        this.bstate = bstate;
    }

    public String getBlnum() {
        return blnum;
    }

    public void setBlnum(String blnum) {
        this.blnum = blnum;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getBdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(bdate);
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getEdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(edate);
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public Boolean getRestate() {
        return restate;
    }

    public void setRestate(Boolean restate) {
        this.restate = restate;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "BorrowInfo{" +
                "bnum='" + bnum + '\'' +
                ", bname='" + bname + '\'' +
                ", collectionnum='" + collectionnum + '\'' +
                ", bstate=" + bstate +
                ", blnum='" + blnum + '\'' +
                ", blname='" + blname + '\'' +
                ", snum='" + snum + '\'' +
                ", bdate=" + bdate +
                ", edate=" + edate +
                ", restate=" + restate +
                ", rnum='" + rnum + '\'' +
                ", rname='" + rname + '\'' +
                ", rfmoney=" + rfmoney +
                ", reason='" + reason + '\'' +
                ", brstate=" + brstate +
                '}';
    }
}
