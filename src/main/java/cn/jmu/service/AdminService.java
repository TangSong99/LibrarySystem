package cn.jmu.service;

import cn.jmu.entity.Admin;
import cn.jmu.entity.Bookinfo;
import cn.jmu.entity.ReaderInfo;

public interface AdminService {
    Admin findAdminById(String usernum);

    //String submitAddBook(Bookinfo bookinfo);

    int isbookexist(Bookinfo bookinfo);

    String submitAddBooknotexit(Bookinfo bookinfo);

    String submitAddBookexit(Bookinfo bookinfo);

    String deleteReader(ReaderInfo readerinfo);

    String updateReader(ReaderInfo readerinfo);

}
