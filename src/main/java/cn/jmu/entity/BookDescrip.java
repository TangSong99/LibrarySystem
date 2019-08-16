package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 20:47
 */
public class BookDescrip {
    private String collectionnum;//馆藏编号
    private String pnum;//出版社编号
    private String ccnum;//分类编号
    private String btnum;//借阅种类编号新书旧书
    private String ISBN;//ISBN号
    private String bname;//书名
    private int wordnum;//字数
    private double price;//价格

    public String getCollectionnum() {
        return collectionnum;
    }

    public void setCollectionnum(String collectionnum) {
        this.collectionnum = collectionnum;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getCcnum() {
        return ccnum;
    }

    public void setCcnum(String ccnum) {
        this.ccnum = ccnum;
    }

    public String getBtnum() {
        return btnum;
    }

    public void setBtnum(String btnum) {
        this.btnum = btnum;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getWordnum() {
        return wordnum;
    }

    public void setWordnum(int wordnum) {
        this.wordnum = wordnum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookDescrip{" +
                "collectionnum='" + collectionnum + '\'' +
                ", pnum='" + pnum + '\'' +
                ", ccnum='" + ccnum + '\'' +
                ", btnum='" + btnum + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", bname='" + bname + '\'' +
                ", wordnum=" + wordnum +
                ", price=" + price +
                '}';
    }
}
