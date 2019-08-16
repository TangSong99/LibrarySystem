package cn.jmu.controller;

import java.util.List;

import cn.jmu.entity.ReaderInfo;
import cn.jmu.service.AdminService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jmu.entity.Company;
import cn.jmu.entity.Reader;
import cn.jmu.entity.User;
import cn.jmu.service.ReaderService;
import cn.jmu.service.UserService;

@Controller
public class ReaderController {
	@Autowired
	private ReaderService readerService;
	@Autowired
	private UserService userService;


	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "deleteReader.do")
	@ResponseBody
	public String deleteReader(ReaderInfo readerinfo) {
		return adminService.deleteReader(readerinfo);
	}


	@RequestMapping(value="checkReader.do")	
	@ResponseBody
 	public String checkReader(String usernum) {
		int a=readerService.checkReader(usernum);
		System.out.println(a);
		 return a>0?"0":"1";
 	}
	
	@RequestMapping(value="addReader.do")
	@ResponseBody
	public String addReader(User user,Company company,Reader reader)
	{
		System.out.println(user.toString());
		System.out.println(company.toString());
		int a = readerService.addCompany(company);
		a = readerService.addReader(reader);
		a = userService.addUser(user);
		//System.out.println(reader.toString());
		//user
		return a>0?"1":"0";
	}

	@RequestMapping(value="listDisBack.do")
	public String listDisBack(){
		return "reader/listDisBack";
	}

	@RequestMapping(value="updateReaderInfo.do")
	public String updateUser(){	return "reader/updateReaderInfo";}

//	@RequestMapping(value="updateReader.do")
//	@ResponseBody
//	public String updateReader(ReaderInfo readerInfo){
//		System.out.println("rnum"+readerInfo.getRnum());
//		readerService.updateReader(readerInfo);
//		return "1";
//	}

	@RequestMapping(value = "updateReader.do")
	@ResponseBody
	public String updateReader(ReaderInfo readerinfo) {
		return adminService.updateReader(readerinfo);
	}

	@RequestMapping(value = "readerIndex.do")
	public String readerIndex() {
		return "admin/readerIndex";
	}

	@RequestMapping(value = "inform.do")
	@ResponseBody
	public String inform(){return "ok"; }

	@RequestMapping(value = "listReader.do")
	@ResponseBody
	public String listReader( ){
		List<ReaderInfo> list = readerService.listReader();
		JSONObject obj = new JSONObject();
		obj.put("code", 0);
		obj.put("msg", "");
		obj.put("count",list.size());
		obj.put("data", list);
		return obj.toString();
	}

	@RequestMapping(value = "addReaders.do")
	public String addReader(){return "admin/addReader";}

	@RequestMapping(value = "editReader.do")
	public String editreader(ReaderInfo readerinfo, Model model) {
		readerinfo.setUserpwd(readerService.findUserpwd(readerinfo.getRnum()));
		model.addAttribute("readerinfo",readerinfo);
		model.addAttribute("code",1);
		return "admin/addReader";
	}

}
