package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 22:21
 */
public class BorrowType {
    private String btnum;
    private String btname;

    public String getBtnum() {
        return btnum;
    }

    public void setBtnum(String btnum) {
        this.btnum = btnum;
    }

    public String getBtname() {
        return btname;
    }

    public void setBtname(String btname) {
        this.btname = btname;
    }

    @Override
    public String toString() {
        return "BorrowType{" +
                "btnum='" + btnum + '\'' +
                ", btname='" + btname + '\'' +
                '}';
    }
}
