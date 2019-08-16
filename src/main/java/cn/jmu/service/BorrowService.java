package cn.jmu.service;

import cn.jmu.entity.Bookinfo;
import cn.jmu.entity.BorrowInfo;
import cn.jmu.entity.PageBean;
import cn.jmu.entity.ReaderInfo;

import java.util.List;

public interface BorrowService {

    ReaderInfo AllReaderInfo(String rnum);

    int isoverdue(String rnum);

    void updateBorrow();

    int isoutofStock(Bookinfo bookinfo);

    boolean isMaxnum(ReaderInfo readerInfo);

    void borrowBook(ReaderInfo readerInfo, Bookinfo bookinfo);

    List<BorrowInfo> listDisBackBook(PageBean pageBean);

    PageBean getPb();

    void backBook(ReaderInfo readerInfo, Bookinfo bookinfo);

    String lastBook(ReaderInfo readerInfo, BorrowInfo borrowInfo);

    List<BorrowInfo> listDisBackBook2(PageBean pageBean);
}
