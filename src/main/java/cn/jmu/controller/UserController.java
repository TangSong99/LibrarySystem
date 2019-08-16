package cn.jmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.service.UserService;

@Controller
public class UserController {
	//@Resource(name="UserServiceImpl")
	@Autowired
	private UserService userService;

//	@RequestMapping(value="addUser.do")
//	public String addUser(User user,Model model)
//	{
//		return "addUser";
//	}
//	@RequestMapping(value="updateReader.do")
//	public String updateUser(String rnum,Model model)
//	{
//		int num=userService.updateUser(rnum);
//		model.addAttribute("flag",num);
//		return "updateUser";
//	}
//	@RequestMapping(value="findById.do")
//	public String findById(String usernum,Model model)
//	{
//		User user=userService.findById(usernum);
//		model.addAttribute("reader",user);
//		return "findById";
//	}
//	@RequestMapping(value="findAll.do")
//	public String findAll(Model model)
//	{
//		List<User> user=userService.findAll();
//		model.addAttribute("all",user);
//		return "findAll";
//	}
//	@RequestMapping(value="deleteUser.do")
//	public String deleteUser(String usernum,Model model)
//	{
//		int num=userService.deleteUser(usernum);
//		model.addAttribute("flag",num);
//		return "deleteUser";
//	}
}
