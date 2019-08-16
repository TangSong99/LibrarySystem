package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 17:19
 */
public class ReaderFine {
    private int rfnum;
    private String rnum;
    private double rfmoney;
    private String reason;

    public int getRfnum() {
        return rfnum;
    }

    public void setRfnum(int rfnum) {
        this.rfnum = rfnum;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public double getRfmoney() {
        return rfmoney;
    }

    public void setRfmoney(double rfmoney) {
        this.rfmoney = rfmoney;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ReaderFine{" +
                "rfnum=" + rfnum +
                ", rnum='" + rnum + '\'' +
                ", rfmoney=" + rfmoney +
                ", reason='" + reason + '\'' +
                '}';
    }
}
