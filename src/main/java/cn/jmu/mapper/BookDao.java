package cn.jmu.mapper;

import cn.jmu.entity.*;

import java.util.List;

public interface BookDao {

    List<Bookinfo> listAllBook(PageBean pageBean);

    int bookCount(PageBean pageBean);

    int findAnum(Bookinfo bookinfo);

    String findAname(Bookinfo bookinfo);

    String findRolename(Bookinfo bookinfo);

    int findInstocknum(Bookinfo bookinfo);

    List<ChineseClass> listChineseClass();

    String findBlname(String blnum);

    void updateBookType(ChineseClass chineseclass);

    void addBookType(ChineseClass chineseclass);

    void delBookType(ChineseClass chineseclass);

    List<Bookinfo> listAllBook2(PageBean pageBean2);

    int bookCount2(PageBean pageBean);

    List<Press> listPress();

    List<BranchLibraries> listBranchLibraries();

    List<BorrowType> listBorrowType();

    void updateBook(Bookinfo bookinfo);
}
