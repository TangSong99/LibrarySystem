package cn.jmu.entity;

import java.util.Date;

/**
 * @author CTX
 * @since 2019/7/5 22:34
 */
public class Semester {
    private String snum;
    private Date bdate;
    private Date edate;

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

    @Override
    public String toString() {
        return "Semester{" +
                "snum='" + snum + '\'' +
                ", bdate=" + bdate +
                ", edate=" + edate +
                '}';
    }
}
