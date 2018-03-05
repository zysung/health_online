package cn.edu.gdin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.gdin.po.User;
import cn.edu.gdin.service.UserService;

/**
 * 后台用户管理页面控制
 * @author zysung
 *	@date 2017年2月25日
 */
@Controller
@RequestMapping("/back")
public class BackUserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/users","/"},method=RequestMethod.GET)
	public String findUsers(Model model,String condition){
		model.addAttribute("pager",userService.findUsersByCondition(condition));
		model.addAttribute("condition", condition);
		return "user/users";
	}
	/*@RequestMapping(value="/searchUsers",method=RequestMethod.GET)
	public String findByCondition(Model model,@RequestParam(value="condition") String condition){
		model.addAttribute("pager", userService.findUsersByCondition(condition));
		return "back/users";
	}*/
	@RequestMapping(value="/{account}/deleteUser",method=RequestMethod.GET)
	public String deleteUser(@PathVariable String account){
		User user = userService.loadUser(account);
		if(user != null){
			userService.deleteUser(account);
		}
		return "redirect:/back/users";
	}
	/**
	 * 3.31更新，jsp页面读取图片测试，完美
	 */
	@RequestMapping(value="{account}/avatar",method=RequestMethod.GET)
	public void avatarTest(HttpServletResponse response,@PathVariable String account){
		User u = userService.loadUser(account);
		try {
			if(u.getAvatar() != null){
				response.getOutputStream().write(u.getAvatar());
				response.getOutputStream().flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 5.9更新，用户详情页
	 */
	@RequestMapping(value="{account}/show",method=RequestMethod.GET)
	public String show(@PathVariable String account,Model model){
		model.addAttribute("user",userService.loadUser(account));
		return "user/show";
	}
}
