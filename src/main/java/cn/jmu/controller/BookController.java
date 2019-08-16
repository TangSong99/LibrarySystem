package cn.jmu.controller;

import cn.jmu.entity.Bookinfo;
import cn.jmu.entity.ChineseClass;
import cn.jmu.entity.PageBean;
import cn.jmu.service.AdminService;
import cn.jmu.service.BookService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value={"ChineseClass","Press","BranchLibraries","BorrowType"})
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "listBook.do", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String listBook(@RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                    PageBean pageBean, Model model) {
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(limit);
        System.out.println(pageBean.toString());
        // 转化为json
        List<Bookinfo> list = bookService.listAllBook(pageBean);
        System.out.println(list.toString());
        PageBean pb=bookService.getPb();
        // 讲json发送给浏览器
        // list转成json
        JSONObject obj = new JSONObject();
        // Layui table 组件要求返回的格式
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pb.getTotalCount());
        obj.put("data", list);
        model.addAttribute("ChineseClass",bookService.listChineseClass());
        System.out.println(obj.toString());
        return obj.toString();

    }

    @RequestMapping(value = "listBook2.do", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String listBook2(@RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                    PageBean pageBean, Model model) {
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(limit);
        //System.out.println(pageBean.toString());
        // 转化为json
        List<Bookinfo> list = bookService.listAllBook2(pageBean);
        PageBean pb=bookService.getPb();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",pb.getTotalCount());
        obj.put("data", list);
        System.out.println(list.toString());
        model.addAttribute("ChineseClass",bookService.listChineseClass());
        model.addAttribute("Press",bookService.listPress());
        model.addAttribute("BranchLibraries",bookService.listBranchLibraries());
        model.addAttribute("BorrowType",bookService.listBorrowType());
        System.out.println(obj.toString());
        return obj.toString();

    }

    @RequestMapping(value = "bookType.do")
    public String bookType() {
        return "admin/bookType";
    }

    //图书分类异步请求
    @RequestMapping(value = "bookTypeList.do", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String listChineseClass(HttpSession session) {
        ArrayList<ChineseClass> list=(ArrayList<ChineseClass>) bookService.listChineseClass();
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",list.size());
        obj.put("data", list);
        return obj.toString();
    }

    //修改图书类别
    @RequestMapping(value = "editBookType.do")
    public @ResponseBody String editBookType(@ModelAttribute(value="chineseclass") ChineseClass chineseclass) {
        bookService.updateBookType(chineseclass);
        return "1";
    }
    //添加类别
    @RequestMapping(value = "addBookType.do")
    public @ResponseBody String addBookType(@ModelAttribute(value="chineseclass") ChineseClass chineseclass) {
        bookService.addBookType(chineseclass);
        return "1";
    }

    //删除类别
    @RequestMapping(value = "delBookType")
    public @ResponseBody String delBookType(@ModelAttribute(value="chineseclass") ChineseClass chineseclass) {
        bookService.delBookType(chineseclass);
        return "1";
    }

    @RequestMapping(value = "addBook.do")
    public String addBook(){return "admin/addBook";}

    @RequestMapping(value = "submitAddBook.do")
    @ResponseBody
    public String submitAddBook(Bookinfo bookinfo){
        System.out.println("---------"+bookinfo.toString());
        bookinfo.setCollectionnum(bookinfo.getBlnum()+bookinfo.getISBN());
        int num=adminService.isbookexist(bookinfo);
        System.out.println(num);
        if(num==0){
            return adminService.submitAddBooknotexit(bookinfo);
        }else {
            return adminService.submitAddBookexit(bookinfo);
        }
    }

    @RequestMapping(value = "editBook.do", produces = "text/plain;charset=UTF-8")
    public String editBook(Bookinfo bookinfo,Model model) {
        model.addAttribute("bookinfo",bookinfo);
        System.out.println("edit"+bookinfo.toString());
        model.addAttribute("code",1);
        return "admin/addBook";
    }
    @RequestMapping(value = "updateBook.do", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String updateBook(Bookinfo bookinfo) {
       bookService.updateBook(bookinfo);
        return "1";
    }

    @RequestMapping(value = "delBook.do", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String delBook(Bookinfo bookinfo) {
        System.out.println(bookinfo.toString());
        bookService.delBook(bookinfo);
        return "1";
    }
}
