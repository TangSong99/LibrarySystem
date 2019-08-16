package cn.jmu.controller;

import cn.jmu.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jmu.entity.User;
import cn.jmu.service.AdminService;
import cn.jmu.service.ReaderService;
import cn.jmu.service.UserService;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(value={"user"})
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ReaderService readerService;
	@Autowired
	private BorrowService borrowService;
	//用于跳转,ajax返回成功跳转到管理员界面
	@RequestMapping(value = "/index")
	public String login() {
		return "admin/index";
	}
	//读者借阅界面
	@RequestMapping(value = "/frontIndex")
	public String login2() {
		return "reader/frontIndex";
	}
	
	//ajax请求过来
	@RequestMapping(value = "login.do")
	@ResponseBody
	public String list(User user,Model model){
		System.out.println(user.toString());
		if(userService.login(user)==null){
			return "null";
		}else {
			borrowService.updateBorrow();
			System.out.println(userService.login(user).toString());
			User nowuser = userService.login(user);
			if(nowuser.getRolenum().equals("0")){//读者
				System.out.println(readerService.findReaderById(nowuser.getUsernum()));
				System.out.println(readerService.findReaderById(nowuser.getUsernum()).getRname());
				model.addAttribute("user",readerService.findReaderById(nowuser.getUsernum()));
			}else if(nowuser.getRolenum().equals("1")){
				System.out.println(adminService.findAdminById(nowuser.getUsernum()));
				model.addAttribute("user",adminService.findAdminById(nowuser.getUsernum()));
			}
			return nowuser.getRolenum();
		}
	}
	/*//检查原密码
	@RequestMapping(value = "/checkPwd")
	@ResponseBody
	public
	String checkPwd(@RequestParam(value = "password",defaultValue = "0") String password, HttpSession session){
		Admin admin=(Admin) session.getAttribute("admin2");
		//直接获取session中的密码进行比较
		return admin.getPassword().equals(password)?"1":"0";
	}
	//跳转到修改密码界面
	@RequestMapping(value = "/toAlterpwdPage")
	public String toAlterpwdPage() {
		return "alterPwd";
	}
	//修改密码
	@RequestMapping(value = "/alterpwd")
	public  @ResponseBody
	String alterpwd(Admin admin,HttpSession session){
		Admin admin1=(Admin) session.getAttribute("admin2");
		admin1.setPassword(admin.getPassword());
		adminService.alterpwd(admin1);
		return "1";
	}
*/
	//注销
	@RequestMapping(value = "/loginout")
//	public  String loginout(HttpSession session, HttpServletRequest request){
//		//session.invalidate();
//		request.getSession().removeAttribute("user");
//		return "redirect:login.jsp";
//	}
	public String loginout(HttpSession session, HttpServletRequest request, HttpServletResponse response, SessionStatus sessionStatus) {
		session.removeAttribute("user");
		sessionStatus.setComplete();
		return "redirect:/login.jsp";
	}
}
