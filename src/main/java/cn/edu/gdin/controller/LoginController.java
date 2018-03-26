package cn.edu.gdin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.edu.gdin.po.User;
import cn.edu.gdin.service.UserService;
import cn.edu.gdin.util.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.edu.gdin.service.AdminService;
import cn.edu.gdin.po.Admin;

@Controller
@RequestMapping("/admin") //url为   项目名/admin/*
@SessionAttributes("loginAdmin")
public class LoginController {
	
	@Autowired
	private UserService userService;
//	private AdminService adminService;
	/*
	 *后台登录页面
	 */
	@RequestMapping(value={"/login","/",""},method=RequestMethod.GET)
	public String login(){
		System.out.println("----------------------------");
		return "/admin/login";
	}
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String adminname,String password,Model model){
//		Admin a = (Admin) adminService.login(adminname, password).getData();
//		if(a != null){
//			model.addAttribute("loginAdmin", a);
//		}
//		return "redirect:/back/users";
		System.out.println("login login");
		//shiro实现用户登陆
		UsernamePasswordToken token = null;
		try {
			token = new UsernamePasswordToken(adminname, MD5.getMD5(password));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);

		User u  = userService.loadUser(adminname);
		if(u!=null){
			model.addAttribute("loginAdmin",u);
		}

		if(subject.hasRole("admin")){
			return "redirect:/back/users";
		}else if(subject.hasRole("user")){
			return "redirect:/user/hospital/hospitals";
		}else if(subject.hasRole("doctor")){
			return "redirect:/doctor/data/userstocustodydatas";
		}
		return "/admin";
	}
	/**
	 * 管理员退出登录
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(Model model,HttpSession session){
		model.asMap().remove("loginAdmin");
		session.invalidate();   //让session中的loginAdmin失效
		return "redirect:/admin/login";
	}
	//ajax json实现动态检错
		@ResponseBody
		@RequestMapping(value="/checknamejson",method=RequestMethod.POST)
		public boolean jsonCheckName(HttpServletRequest req){
			String adminName = req.getParameter("adminName");
			System.out.println(adminName);
//			Admin admin = adminService.loadByName(adminName);
			User u = userService.loadUser(adminName);
					System.out.println("user=="+u);
			if(u==null) return false;
			return true;
		}
		@ResponseBody
		@RequestMapping(value="/checkpassjson",method=RequestMethod.POST)
		public boolean jsonCheckPass(HttpServletRequest req){
			String adminName = req.getParameter("adminName");
			String password = req.getParameter("password");
			System.out.println(adminName);
//			Admin admin = adminService.loadByName(adminName);
			User u = userService.loadUser(adminName);
			try {
				if(u.getPassword().equals(MD5.getMD5(password))) return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	
	
	
	
}
