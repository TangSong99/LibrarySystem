package cn.jmu.service;

import cn.jmu.entity.*;

import java.util.List;

public interface BookService {

    List<Bookinfo> listAllBook(PageBean pageBean);

    PageBean getPb();


    List<ChineseClass> listChineseClass();

    void updateBookType(ChineseClass chineseclass);

    void addBookType(ChineseClass chineseclass);

    void delBookType(ChineseClass chineseclass);

    List<Bookinfo> listAllBook2(PageBean pageBean);

    List<Press> listPress();

    List<BranchLibraries> listBranchLibraries();

    List<BorrowType> listBorrowType();

    void updateBook(Bookinfo bookinfo);

    void delBook(Bookinfo bookinfo);
}
