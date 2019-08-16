package cn.jmu.service.impl;

import cn.jmu.entity.Bookinfo;
import cn.jmu.entity.BorrowInfo;
import cn.jmu.entity.PageBean;
import cn.jmu.entity.ReaderInfo;
import cn.jmu.mapper.BorrowDao;
import cn.jmu.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImp implements BorrowService {
    @Autowired
    BorrowDao borrowDao;
    private PageBean pb;

    @Override
    public ReaderInfo AllReaderInfo(String rnum) {
        return borrowDao.AllReaderInfo(rnum);
    }

    @Override
    public int isoverdue(String rnum) {
        return borrowDao.isoverdue(rnum);
    }

    @Override
    public void updateBorrow() {
        borrowDao.updateBorrow();
        borrowDao.updateReader();
    }

    @Override
    public int isoutofStock(Bookinfo bookinfo) {
        return borrowDao.isoutofStock(bookinfo);
    }

    @Override
    public boolean isMaxnum(ReaderInfo readerInfo) {
        if(readerInfo.getMaxnum()<=borrowDao.getBorrownum(readerInfo.getRnum())){
            return true;
        }
        return false;
    }

    @Override
    public void borrowBook(ReaderInfo readerInfo, Bookinfo bookinfo) {
        String snum = borrowDao.findBorrowSnum();
        String bnum = borrowDao.findBorrowbnum(bookinfo.getBlnum(),bookinfo.getISBN());
        int brdate = borrowDao.findBorrowBrdate(readerInfo.getRcnum(),bookinfo.getBtnum());
        Date edate = new Date();
        if(borrowDao.findBorrowEdate(brdate)==null){
            if(snum.indexOf("last")!=-1){//上半年
                edate = borrowDao.setBorrowEdate(70,snum);
            }else{
                edate = borrowDao.setBorrowEdate(40,snum);
            }
        }else{
            edate = borrowDao.findBorrowEdate(brdate);
        }
        borrowDao.borrowBook(readerInfo.getRnum(),bnum,snum,edate);
        borrowDao.borrowBstate(bnum);
        borrowDao.reduceStock(bookinfo.getCollectionnum(),bookinfo.getBlnum());
    }

    @Override
    public List<BorrowInfo> listDisBackBook(PageBean pageBean) {
        //获得总页数
        int bookcount=borrowDao.borrowCount(pageBean);
        //设置分页相关属性数据
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),bookcount,pageBean.getPageSize());
        pageBean2.setBname(pageBean.getBname());
        pageBean2.setBrstate(pageBean.getBrstate());
        pageBean2.setRnum(pageBean.getRnum());
        pageBean2.setRname(pageBean.getRname());
        pageBean2.setRcnum(pageBean.getRcnum());
        pageBean2.setIndex(pageBean.getIndex());
        pb=pageBean2;
        System.out.println("***********************************");
        System.out.println("-----"+pageBean2.toString()+"----");
        List<BorrowInfo> list = new ArrayList<BorrowInfo>();
        list = borrowDao.listDisBackBook(pageBean2);
        System.out.println("***********************************");
        System.out.println(list.toString());
        System.out.println("***********************************");
        System.out.println("-----"+pageBean2.toString()+"----");
        for(int i=0;i<list.size();i++){
            list.get(i).setRfmoney(borrowDao.findBorrowRfmoney(list.get(i)));
            System.out.println("......"+borrowDao.findBorrowRfmoney(list.get(i)));
            System.out.println(list.get(i).getRfmoney());
            list.get(i).setReason(borrowDao.findBorrowReason(list.get(i)));
            list.get(i).setBlname(borrowDao.findBorrowBlname(list.get(i).getBlnum()));
        }
        return list;
    }

    @Override
    public PageBean getPb() {
        return pb;
    }

    @Override
    public void backBook(ReaderInfo readerInfo, Bookinfo bookinfo) {
        borrowDao.backBook(bookinfo.getBnum(),bookinfo.getCollectionnum(),readerInfo.getRnum());
        borrowDao.deleteReaderfine(bookinfo.getBnum(),readerInfo.getRnum());
    }

    @Override
    public String lastBook(ReaderInfo readerInfo, BorrowInfo borrowInfo) {
        int brdate = borrowDao.findBorrowBrdate2(readerInfo.getRcnum(),borrowInfo.getCollectionnum());//续借遇到暑假问题
        Date edate = new Date();
        System.out.println(readerInfo.getRnum());
        System.out.println(borrowDao.findBorrowRestate(borrowInfo.getBnum(),readerInfo.getRnum()));
        if(borrowDao.findBorrowRestate(borrowInfo.getBnum(),readerInfo.getRnum())==0){//续借过
            return "1";
        }else{
            edate = borrowDao.findBorrowEdate2(borrowInfo.getBnum(),readerInfo.getRnum());
//            if(borrowDao.findBorrowEdate(brdate)==null){
//                if(borrowInfo.getSnum().indexOf("last")!=-1){//上半年
//                    edate = borrowDao.setBorrowEdate(70,borrowInfo.getSnum());
//                }else{
//                    edate = borrowDao.setBorrowEdate(40,borrowInfo.getSnum());
//                }
//            }else{
//                edate = borrowDao.findBorrowEdate(brdate);
//            }
        }
        borrowDao.updateEdate(borrowInfo.getBnum(),brdate,edate);
        return "0";
    }

    @Override
    public List<BorrowInfo> listDisBackBook2(PageBean pageBean) {
        //获得总页数
        int bookcount=borrowDao.borrowCount2(pageBean);
        //设置分页相关属性数据
        PageBean pageBean2=new PageBean(pageBean.getCurrentPage(),bookcount,pageBean.getPageSize());
        pageBean2.setBname(pageBean.getBname());
        pageBean2.setBrstate(pageBean.getBrstate());
        pageBean2.setRnum(pageBean.getRnum());
        pageBean2.setRname(pageBean.getRname());
        pageBean2.setRcnum(pageBean.getRcnum());
        pageBean2.setIndex(pageBean.getIndex());
        pb=pageBean2;
        System.out.println("-----"+pageBean2.toString()+"----");
        List<BorrowInfo> list = new ArrayList<BorrowInfo>();
        list = borrowDao.listDisBackBook2(pageBean2);
        System.out.println(list.toString());
        for(int i=0;i<list.size();i++){
            list.get(i).setRfmoney(borrowDao.findBorrowRfmoney(list.get(i)));
            System.out.println("......"+borrowDao.findBorrowRfmoney(list.get(i)));
            System.out.println(list.get(i).getRfmoney());
            list.get(i).setReason(borrowDao.findBorrowReason(list.get(i)));
            list.get(i).setBlname(borrowDao.findBorrowBlname(list.get(i).getBlnum()));
        }
        return list;
    }
}
