package cn.jmu.entity;

/**
 * @author CTX
 * @since 2019/7/5 20:16
 */
public class PageBean {
    // 当前页数
    private Integer currentPage;
    // 总记录数
    private Integer totalCount;
    // 每页显示条数
    private Integer pageSize;
    // 总页数
    private Integer totalPage;
    // 起始索引
    private Integer index;
    // 图书搜索条件
    private String bname;// 书名字
    private String ccnum;// 类别
    //读者搜索条件
    private String rnum;// 读者
    private String rname;//读者名字
    private String rcnum;

    public String getRcnum() {
        return rcnum;
    }

    public void setRcnum(String rcnum) {
        this.rcnum = rcnum;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    private String lnum;//管理员

    //借阅搜索条件
    private int brstate=2;//归还状态
    //书名

    public PageBean() {

    }

    public String getLnum() {
        return lnum;
    }

    public void setLnum(String lnum) {
        this.lnum = lnum;
    }

    public int getBrstate() {
        return brstate;
    }

    public void setBrstate(int brstate) {
        this.brstate = brstate;
    }

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.totalCount = totalCount;

        this.pageSize = pageSize;

        this.currentPage = currentPage;

        if (this.currentPage == null) {
            // 如页面没有指定显示那一页.显示第一页.
            this.currentPage = 1;
        }

        if (this.pageSize == null) {
            // 如果每页显示条数没有指定,默认每页显示3条
            this.pageSize = 3;
        }

        // 计算总页数
        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;

        // 判断当前页数是否超出范围
        // 不能小于1
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        // 不能大于总页数
        if (this.currentPage > this.totalPage) {
            this.currentPage = this.totalPage;
        }

    }

    //	// 计算起始索引
//	public int getStart() {
//		return (this.currentPage - 1) * this.pageSize;
//	}
    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getCcnum() {
        return ccnum;
    }

    public void setCcnum(String ccnum) {
        this.ccnum = ccnum;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getIndex() {

        return (this.currentPage - 1) * this.pageSize;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }
    public String getRnum() {
        return rnum;
    }
    public void setRnum(String rnum) {
        this.rnum = rnum;
    }


    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", index=" + index +
                ", bname='" + bname + '\'' +
                ", ccnum='" + ccnum + '\'' +
                ", rnum='" + rnum + '\'' +
                ", rname='" + rname + '\'' +
                ", rcnum='" + rcnum + '\'' +
                ", lnum='" + lnum + '\'' +
                ", brstate=" + brstate +
                '}';
    }
}
