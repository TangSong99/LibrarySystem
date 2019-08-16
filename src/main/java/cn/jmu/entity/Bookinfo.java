package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/6 13:19
 */
public class Bookinfo {
    private String bnum;
    private String collectionnum;
    private int bstate;
    private String blnum;
    private String pnum;//出版社编号
    private String ccnum;//分类编号
    private String btnum;//借阅种类编号新书旧书
    private String ISBN;//ISBN号
    private String bname;//书名
    private int wordnum;//字数
    private double price;//价格
    private String ccexplain;
    private String ccsup;
    private String btname;
    private String pname;
    private String padress;

    private int anum;
    private String aname;
    private String rolename;
    private int instocknum;
    private String blname;

    public String getBlname() {
        return blname;
    }

    public void setBlname(String blname) {
        this.blname = blname;
    }

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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public int getInstocknum() {
        return instocknum;
    }

    public void setInstocknum(int instocknum) {
        this.instocknum = instocknum;
    }

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

    public String getCcexplain() {
        return ccexplain;
    }

    public void setCcexplain(String ccexplain) {
        this.ccexplain = ccexplain;
    }

    public String getCcsup() {
        return ccsup;
    }

    public void setCcsup(String ccsup) {
        this.ccsup = ccsup;
    }

    public String getBtname() {
        return btname;
    }

    public void setBtname(String btname) {
        this.btname = btname;
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

    public String getBlnum() {
        return blnum;
    }

    public void setBlnum(String blnum) {
        this.blnum = blnum;
    }

    @Override
    public String toString() {
        return "Bookinfo{" +
                "bnum='" + bnum + '\'' +
                ", collectionnum='" + collectionnum + '\'' +
                ", bstate=" + bstate +
                ", blnum='" + blnum + '\'' +
                ", pnum='" + pnum + '\'' +
                ", ccnum='" + ccnum + '\'' +
                ", btnum='" + btnum + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", bname='" + bname + '\'' +
                ", wordnum=" + wordnum +
                ", price=" + price +
                ", ccexplain='" + ccexplain + '\'' +
                ", ccsup='" + ccsup + '\'' +
                ", btname='" + btname + '\'' +
                ", pname='" + pname + '\'' +
                ", padress='" + padress + '\'' +
                ", anum='" + anum + '\'' +
                ", aname='" + aname + '\'' +
                ", rolename='" + rolename + '\'' +
                ", instocknum=" + instocknum +
                ", blname='" + blname + '\'' +
                '}';
    }
}
