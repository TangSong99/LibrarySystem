package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 21:06
 */
public class BranchLibraries {
    private String blnum;
    private String blname;

    public String getBlnum() {
        return blnum;
    }

    public void setBlnum(String blnum) {
        this.blnum = blnum;
    }

    public String getBlname() {
        return blname;
    }

    public void setBlname(String blname) {
        this.blname = blname;
    }

    @Override
    public String toString() {
        return "BranchLibraries{" +
                "blnum='" + blnum + '\'' +
                ", blname='" + blname + '\'' +
                '}';
    }
}
