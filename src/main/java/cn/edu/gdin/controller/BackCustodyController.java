package cn.edu.gdin.controller;

import cn.edu.gdin.po.Custody;
import cn.edu.gdin.po.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.gdin.service.CustodyService;
import cn.edu.gdin.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

/**
 * 后台监护数据页面控制
 * @author zysung
 * @date 2017年2月26日
 */

@Controller
@RequestMapping("/back/data")
public class BackCustodyController {

	@Autowired
	private CustodyService custodyService;
	@Autowired
	private UserService userService;
	/**
	 * 根据用户查询监护数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/userstocustodydatas",method=RequestMethod.GET)
    public String findCustodyDatasByUsers(Model model, String condition,
										  @RequestParam(required = false,defaultValue ="1")Integer page,
										@RequestParam(required = false,defaultValue = "6")Integer rows){

		PageHelper.startPage(page,rows);
		List<User> allList = userService.findUsersByCondition(condition);
		PageInfo<User> p  = new PageInfo<User>(allList);
		model.addAttribute("page",p);
		model.addAttribute("condition", condition);
		return "back/data/userstocustodydatas";
	}
    /**
     * 模糊查询用户
     * @param model
     * @param condition
     * @return
     */
 /*   @RequestMapping(value="/searchUserstocustodydatas",method=RequestMethod.POST)
    public String findByCondition(Model model, String condition){
    	model.addAttribute("pager", userService.findUsersByCondition(condition));
    	return "back/userstocustodydatas";
    }*/
    /**
     * 查询某用户最新监护数据
     * @param account
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/{account}/latestcustodydata",method=RequestMethod.GET)
	public String getLatestSportData(@PathVariable String account,Model model) throws Exception{
		model.addAttribute("latestCustodyData",custodyService.custodyDataDown2(account).getData());
		model.addAttribute("user", userService.loadUser(account));
		return "back/data/latestcustodydata";
	}
    
    /**
     * 查询某用户所有监护数据
     * @param account
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/{account}/custodydatas",method=RequestMethod.GET)
	public String findSportDatas(@PathVariable String account,Model model,
												 @RequestParam(required = false,defaultValue ="1")Integer page,
								 @RequestParam(required = false,defaultValue = "6")Integer rows){
		PageHelper.startPage(page,rows);
		List<Custody> allList = custodyService.findCustodyDatas(account);
		PageInfo<Custody> p  = new PageInfo<Custody>(allList);
		model.addAttribute("page",p);
		model.addAttribute("user", userService.loadUser(account));
		return "back/data/custodydatas";
	}
	
	
}
