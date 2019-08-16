package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 20:37
 */
public class ChineseClass {
    private String ccnum;
    private String ccexplain;
    private String ccsup;

    public String getCcnum() {
        return ccnum;
    }

    public void setCcnum(String ccnum) {
        this.ccnum = ccnum;
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

    @Override
    public String toString() {
        return "ChineseClass{" +
                "ccnum='" + ccnum + '\'' +
                ", ccexplain='" + ccexplain + '\'' +
                ", ccsup='" + ccsup + '\'' +
                '}';
    }
}
