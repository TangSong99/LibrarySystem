package cn.jmu.mapper;

import cn.jmu.entity.Bookinfo;
import cn.jmu.entity.BorrowInfo;
import cn.jmu.entity.PageBean;
import cn.jmu.entity.ReaderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BorrowDao {

    ReaderInfo AllReaderInfo(String rnum);

    int isoverdue(String rnum);

    void updateBorrow();

    void updateReader();

    int isoutofStock(Bookinfo bookinfo);

    int getBorrownum(String rnum);

    void borrowBook(@Param("rnum")String rnum, @Param("bnum")String bnum,@Param("snum")String snum,@Param("edate")Date edate);

    String findBorrowbnum(@Param("blnum")String blnum, @Param("isbn")String isbn);

    String findBorrowSnum();

    Date findBorrowEdate(int brdate);

    int findBorrowBrdate(@Param("rcnum")String rcnum,@Param("btnum")String btnum);

    Date setBorrowEdate(@Param("holidays")int holidays,@Param("snum")String snum);

    void reduceStock(@Param("collectionnum")String collectionnum,@Param("blnum")String blnum);

    void borrowBstate(String bnum);

    int borrowCount(PageBean pageBean);

    List<BorrowInfo> listDisBackBook(PageBean pageBean2);

    Double findBorrowRfmoney(BorrowInfo borrowInfo);

    String findBorrowReason(BorrowInfo borrowInfo);

    void backBook(@Param("bnum") String bnum, @Param("collectionnum") String collectionnum,@Param("rnum") String rnum);

    void deleteReaderfine(@Param("bnum")String bnum, @Param("rnum")String rnum);

    String findBorrowBlname(String blnum);

    int findBorrowRestate(@Param("bnum") String bnum,@Param("rnum") String rnum);

    int findBorrowBrdate2(@Param("rcnum")String rcnum, @Param("collectionnum") String collectionnum);

    Date findBorrowEdate2(@Param("bnum") String bnum,@Param("rnum")String rnum);

    void updateEdate(@Param("bnum") String bnum, @Param("brdate")int brdate, @Param("edate")Date edate);

    List<BorrowInfo> listDisBackBook2(PageBean pageBean2);

    int borrowCount2(PageBean pageBean);
}
