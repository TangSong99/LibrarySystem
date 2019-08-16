package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 20:19
 */
public class Book {
    private String bnum;
    private String collectionnum;
    private int bstate;
    private String blnum;

    public String getBnum() {
        return bnum;
    }

    public void setBnum(String bnum) {
        this.bnum = bnum;
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

    @Override
    public String toString() {
        return "Book{" +
                "bnum='" + bnum + '\'' +
                ", collectionnum='" + collectionnum + '\'' +
                ", bstate=" + bstate +
                ", blnum='" + blnum + '\'' +
                '}';
    }
}
