package cn.jmu.service.impl;

import cn.jmu.entity.Admin;
import cn.jmu.entity.Bookinfo;
import cn.jmu.entity.ReaderInfo;
import cn.jmu.entity.Towrite;
import cn.jmu.mapper.AdminDao;
import cn.jmu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl
        implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin findAdminById(String usernum) {
        return adminDao.findAdminById(usernum);
    }

    @Override
    public String submitAddBooknotexit(Bookinfo bookinfo) {
        adminDao.insertbooknotexist(bookinfo);
        bookinfo.setAnum(adminDao.findanumByaname(bookinfo.getAname()));
        System.out.println(adminDao.findanumByaname(bookinfo.getAname()));
        adminDao.inserttowrite(bookinfo);
        return "1";
    }

    @Override
    public String submitAddBookexit(Bookinfo bookinfo) {
        Towrite towrite=new Towrite();
        towrite=adminDao.findtowriteinfo(bookinfo.getCollectionnum());
        bookinfo.setAnum(towrite.getAnum());
        bookinfo.setRolename(towrite.getRolename());
        adminDao.updatestock(bookinfo.getCollectionnum());
        adminDao.insertBookexist(bookinfo);
        return "1";
    }

    @Override
    public String deleteReader(ReaderInfo readerinfo) {
        int num=adminDao.ifexistreaderfine(readerinfo.getRnum());
        if(num>0)
        {
            adminDao.deletereaderfine(readerinfo.getRnum());

        }
        adminDao.deleteReadernotexit(readerinfo);
        return "1";
    }


    @Override
    public String updateReader(ReaderInfo readerinfo) {
        adminDao.updateReader(readerinfo);
        return "1";
    }

    @Override
    public int isbookexist(Bookinfo bookinfo) {
        return adminDao.isbookexist(bookinfo);
    }

//    @Override
//    public String submitAddBook(Bookinfo bookinfo) {
//        int num=adminDao.isbookexist(bookinfo);
//        System.out.println(num);
//        if(num==0) {
//            adminDao.insertbooknotexist(bookinfo);
//            bookinfo.setAnum(adminDao.findanumByaname(bookinfo.getAname()));
//            System.out.println(adminDao.findanumByaname(bookinfo.getAname()));
//            adminDao.inserttowrite(bookinfo);
//            System.out.println("000");
//            return "1";
//        }else{
//            Towrite towrite=new Towrite();
//            towrite=adminDao.findtowriteinfo(bookinfo.getCollectionnum());
//            bookinfo.setAnum(towrite.getAnum());
//            bookinfo.setRolename(towrite.getRolename());
//            adminDao.updatestock(bookinfo.getCollectionnum());
//            adminDao.insertBookexist(bookinfo);
//            System.out.println("11");
//            return "1";
//        }
//    }
}
