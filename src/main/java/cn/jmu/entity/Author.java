package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 21:39
 */
public class Author {
    private int anum;
    private String aname;

    public int getAnum() {
        return anum;
    }

    public void setAnum(int anum) {
        this.anum = anum;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "anum='" + anum + '\'' +
                ", aname='" + aname + '\'' +
                '}';
    }
}
