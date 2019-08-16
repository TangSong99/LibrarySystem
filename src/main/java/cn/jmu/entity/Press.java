package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 21:52
 */
public class Press {
    private String pnum;
    private String pname;
    private String padress;

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPadress() {
        return padress;
    }

    public void setPadress(String padress) {
        this.padress = padress;
    }

    @Override
    public String toString() {
        return "Press{" +
                "pnum='" + pnum + '\'' +
                ", pname='" + pname + '\'' +
                ", padress='" + padress + '\'' +
                '}';
    }
}
