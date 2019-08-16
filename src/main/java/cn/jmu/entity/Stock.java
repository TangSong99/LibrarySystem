package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 21:46
 */
public class Stock {
    private String blnum;
    private String collectionnum;
    private int stocknumtol;
    private int instocknum;

    public String getBlnum() {
        return blnum;
    }

    public void setBlnum(String blnum) {
        this.blnum = blnum;
    }

    public String getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(String collectionnum) {
        this.collectionnum = collectionnum;
    }

    public int getStocknumtol() {
        return stocknumtol;
    }

    public void setStocknumtol(int stocknumtol) {
        this.stocknumtol = stocknumtol;
    }

    public int getInstocknum() {
        return instocknum;
    }

    public void setInstocknum(int instocknum) {
        this.instocknum = instocknum;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "blnum='" + blnum + '\'' +
                ", collectionnum='" + collectionnum + '\'' +
                ", stocknumtol=" + stocknumtol +
                ", instocknum=" + instocknum +
                '}';
    }
}
