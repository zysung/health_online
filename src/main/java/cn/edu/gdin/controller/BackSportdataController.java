package cn.edu.gdin.controller;

import cn.edu.gdin.po.Sportdata;
import cn.edu.gdin.po.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.gdin.service.SportdataService;
import cn.edu.gdin.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 后台运动数据页面控制
 * @author zysung
 *	@date 2017年2月25日
 */
@Controller
@RequestMapping("/back/data")
public class BackSportdataController {

	@Autowired
	private SportdataService sportdataService;
	@Autowired
	private UserService userService;
	/**
	 * 根据用户查询运动数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/userstosportdatas",method=RequestMethod.GET)
    public String findSportDatasByUsers(Model model,String condition,
										@RequestParam(required = false,defaultValue ="1")Integer page,
										@RequestParam(required = false,defaultValue = "6")Integer rows){

		PageHelper.startPage(page,rows);
		List<User> allList = userService.findUsersByCondition(condition);
		PageInfo<User> p  = new PageInfo<User>(allList);
		model.addAttribute("page",p);
		model.addAttribute("condition", condition);
		return "back/data/userstosportdatas";
	}
    /**
     * 模糊查询
     * @param model
     * @param condition
     * @return
     */
    /*@RequestMapping(value="/searchUserstoSportdata",method=RequestMethod.POST)
    public String findByCondition(Model model, String condition){
    	model.addAttribute("pager", userService.findUsersByCondition(condition));
    	return "back/userstosportdatas";
    }*/
    /**
     * 查询某用户最新运动数据
     * @param account
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/{account}/latestsportdata",method=RequestMethod.GET)
	public String getLatestSportData(@PathVariable String account,Model model) throws Exception{
		model.addAttribute("latestSportData",sportdataService.sportdataDown(account).getData());
		model.addAttribute("user", userService.loadUser(account));
		return "back/data/latestsportdata";
	}
    
    /**
     * 查询某用户所有运动数据
     * @param account
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/{account}/sportdatas",method=RequestMethod.GET)
	public String findSportDatas(@PathVariable String account,Model model,
								 @RequestParam(required = false,defaultValue ="1")Integer page,
								 @RequestParam(required = false,defaultValue = "6")Integer rows){
		PageHelper.startPage(page,rows);
		List<Sportdata> allList = sportdataService.sportdataDownList(account);
		PageInfo<Sportdata> p  = new PageInfo<Sportdata>(allList);
		model.addAttribute("page",p);
		model.addAttribute("user", userService.loadUser(account));
		return "back/data/sportdatas";
	}
    
    /*查询测试*/
	@RequestMapping(value="searchSportdatas",method=RequestMethod.POST)
	public String searchSportDatas(Model model,String searchVal) throws Exception{
		System.out.println(searchVal);
		model.addAttribute("datas",sportdataService.sportdataDownList(searchVal));
		return "back/data/sportdatas";
	}
	
	
	
}
