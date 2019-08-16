package cn.jmu.mapper;

import cn.jmu.entity.Admin;
import cn.jmu.entity.Bookinfo;
import cn.jmu.entity.ReaderInfo;
import cn.jmu.entity.Towrite;

public interface AdminDao {
    Admin findAdminById(String usernum);

    int isbookexist(Bookinfo bookinfo);
    void insertbooknotexist(Bookinfo bookinfo);
    Towrite findtowriteinfo(String collectionnum);
    void updatestock(String collectionnum);
    void insertBookexist(Bookinfo bookinfo);
    void inserttowrite(Bookinfo bookinfo);
    int findanumByaname(String aname);

    int isfinalBook(String collectionnum);

    void deleteBookfinal(Bookinfo bookinfo);

    void deleteBooknotfinal(String bnum);

    void updateinstocknum(String collectionnum);
    void updatestockwhendelete(String collectionnum);

    void updateBook(Bookinfo bookinfo);
    int findAuthorByname(String aname);
    int existAuthor(String aname);
    void insertAuthor(String aname);
    void updatetowrite(Bookinfo bookinfo);

    int ifexistreaderfine(String rnum);
    void deletereaderfine(String rnum);
    void deleteReadernotexit(ReaderInfo readerinfo);
    void updateReader(ReaderInfo readerinfo);
}
