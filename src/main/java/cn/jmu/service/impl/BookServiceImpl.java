package cn.jmu.service.impl;

import cn.jmu.entity.*;
import cn.jmu.mapper.AdminDao;
import cn.jmu.mapper.BookDao;
import cn.jmu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AdminDao adminDao;
    private PageBean pb;
    @Override
    public List<Bookinfo> listAllBook(PageBean pageBean) {
        //获得总页数
        int bookcount=bookDao.bookCount(pageBean);
        //设置分页相关属性数据
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),bookcount,pageBean.getPageSize());
        pageBean2.setBname(pageBean.getBname());
        pageBean2.setCcnum(pageBean.getCcnum());
        pageBean2.setIndex(pageBean.getIndex());
        pb=pageBean2;
        List<Bookinfo> list = bookDao.listAllBook(pageBean2);
        for(int i=0;i<list.size();i++){
            list.get(i).setAnum(bookDao.findAnum(list.get(i)));
            list.get(i).setAname(bookDao.findAname(list.get(i)));
            list.get(i).setRolename(bookDao.findRolename(list.get(i)));
            list.get(i).setInstocknum(bookDao.findInstocknum(list.get(i)));
            list.get(i).setBlname(bookDao.findBlname(list.get(i).getBlnum()));
        }
        //System.out.println("-------" + list.get(0).getCollectionnum().substring(0,1));
        return list;
    }

    @Override
    public PageBean getPb() {
        return pb;
    }

    @Override
    public List<ChineseClass> listChineseClass() {
        return bookDao.listChineseClass();
    }

    @Override
    public void updateBookType(ChineseClass chineseclass) {
        bookDao.updateBookType(chineseclass);
    }

    @Override
    public void addBookType(ChineseClass chineseclass) {
        bookDao.addBookType(chineseclass);
    }

    @Override
    public void delBookType(ChineseClass chineseclass) {
        bookDao.delBookType(chineseclass);
    }

    @Override
    public List<Bookinfo> listAllBook2(PageBean pageBean) {
        //获得总页数
        int bookcount=bookDao.bookCount2(pageBean);
        //设置分页相关属性数据
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),bookcount,pageBean.getPageSize());
        pageBean2.setBname(pageBean.getBname());
        pageBean2.setCcnum(pageBean.getCcnum());
        pageBean2.setIndex(pageBean.getIndex());
        pb=pageBean2;
        List<Bookinfo> list = bookDao.listAllBook2(pageBean2);
        for(int i=0;i<list.size();i++){
            list.get(i).setAnum(bookDao.findAnum(list.get(i)));
            list.get(i).setAname(bookDao.findAname(list.get(i)));
            list.get(i).setRolename(bookDao.findRolename(list.get(i)));
            list.get(i).setInstocknum(bookDao.findInstocknum(list.get(i)));
            list.get(i).setBlname(bookDao.findBlname(list.get(i).getBlnum()));
        }
        //System.out.println("-------" + list.get(0).getCollectionnum().substring(0,1));
        return list;
    }

    @Override
    public List<Press> listPress() {
        return bookDao.listPress();
    }

    @Override
    public List<BranchLibraries> listBranchLibraries() {
        return bookDao.listBranchLibraries();
    }

    @Override
    public List<BorrowType> listBorrowType() {
        return bookDao.listBorrowType();
    }

    @Override
    public void updateBook(Bookinfo bookinfo) {
        bookinfo.setCollectionnum(bookinfo.getBlnum()+bookinfo.getISBN());
        int num=adminDao.existAuthor(bookinfo.getAname());
        if(num==0)
        {
            adminDao.insertAuthor(bookinfo.getAname());
            System.out.println(bookinfo.getAnum());

        }
        bookinfo.setAnum(adminDao.findAuthorByname(bookinfo.getAname()));
        adminDao.updateBook(bookinfo);
        adminDao.updatetowrite(bookinfo);
    }

    @Override
    public void delBook(Bookinfo bookinfo) {
        int num=adminDao.isfinalBook(bookinfo.getCollectionnum());
        if(num==1)
        {
            adminDao.deleteBookfinal(bookinfo);
        }
        else
        {
            adminDao.deleteBooknotfinal(bookinfo.getBnum());
            adminDao.updatestockwhendelete(bookinfo.getCollectionnum());
            if(bookinfo.getBstate()==0)
            {
                adminDao.updateinstocknum(bookinfo.getCollectionnum());
            }
        }
    }
}
