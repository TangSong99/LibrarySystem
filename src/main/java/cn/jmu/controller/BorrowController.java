package cn.jmu.controller;

import cn.jmu.entity.*;
import cn.jmu.service.BorrowService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BorrowController {
    @Autowired
    BorrowService borrowService;
    @RequestMapping(value = "borrowBook.do")
    @ResponseBody
    public String borrowBook(Bookinfo bookinfo, HttpSession session){//ISBN、blnum图书馆编号
        Reader reader = (Reader)session.getAttribute("user");
        ReaderInfo readerInfo = borrowService.AllReaderInfo(reader.getRnum());
        System.out.println("borrow------"+bookinfo.toString());
        System.out.println(reader.toString());
        System.out.println(readerInfo.toString());
        if(reader.getRoverdue()==1){
            return "0";//超期
        }else if(borrowService.isoutofStock(bookinfo)<1){
            return "1";//库存不足
        }else if(borrowService.isMaxnum(readerInfo)){
            return "2";//超过最大借书
        }else{
            borrowService.borrowBook(readerInfo,bookinfo);
            return "ok";
        }

    }

    @RequestMapping(value = "backBook.do")
    @ResponseBody
    public String backBook(Bookinfo bookinfo, HttpSession session){
        Reader reader = (Reader)session.getAttribute("user");
        ReaderInfo readerInfo = borrowService.AllReaderInfo(reader.getRnum());
        System.out.println("back------"+bookinfo.toString());
        System.out.println(reader.toString());
        System.out.println(readerInfo.toString());
        borrowService.backBook(readerInfo,bookinfo);
        return "ok";
    }

    @RequestMapping(value = "lastBook.do")
    @ResponseBody
    public String lastBook(BorrowInfo borrowInfo, HttpSession session){
        Reader reader = (Reader)session.getAttribute("user");
        ReaderInfo readerInfo = borrowService.AllReaderInfo(reader.getRnum());
        System.out.println("last------"+borrowInfo.toString());
        System.out.println(reader.toString());
        System.out.println(readerInfo.toString());
        //borrowService.lastBook(readerInfo,bookinfo);
        if(reader.getRoverdue()==1){
            return "roverdue";
        }else return borrowService.lastBook(readerInfo,borrowInfo);
    }

    //列出未还图书
    @RequestMapping(value = "listDisBackBook.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String listDisBackBook(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "6") Integer limit,
            //@RequestParam(value = "power",defaultValue = "0") Integer power,
            PageBean pageBean, HttpSession session) {
        List<BorrowInfo> list = new ArrayList<BorrowInfo>();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(limit);
        Reader reader = (Reader)session.getAttribute("user");//读者
        pageBean.setRnum(reader.getRnum());
        pageBean.setRname(reader.getRname());
        pageBean.setRcnum(reader.getRcnum());//读者等级  续借
//        System.out.println("--------------------------------------");
//        System.out.println(pageBean.toString());
        list = borrowService.listDisBackBook(pageBean);
        PageBean pb=borrowService.getPb();
        JSONObject obj = new JSONObject();
        // Layui table 组件要求返回的格式
        System.out.println(list.toString());
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pb.getTotalCount());
        obj.put("data", list);
        return obj.toString();
    }

    @RequestMapping(value = "listDisBackBook2.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String listDisBackBook2(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "6") Integer limit,
            //@RequestParam(value = "power",defaultValue = "0") Integer power,
            PageBean pageBean, HttpSession session) {
        List<BorrowInfo> list = new ArrayList<BorrowInfo>();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(limit);
//        System.out.println("--------------------------------------");
//        System.out.println(pageBean.toString());
        list = borrowService.listDisBackBook2(pageBean);
        PageBean pb=borrowService.getPb();
        JSONObject obj = new JSONObject();
        // Layui table 组件要求返回的格式
        System.out.println(list.toString());
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pb.getTotalCount());
        obj.put("data", list);
        return obj.toString();
    }

    @RequestMapping(value = "/listDisBackReader")
    public  String listDisBackReader() {
        return "admin/listDisBackReader";
    }
}
