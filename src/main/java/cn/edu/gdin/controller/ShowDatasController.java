package cn.edu.gdin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.gdin.service.CustodyService;
import cn.edu.gdin.service.SportdataService;
import cn.edu.gdin.service.UserService;

/**
 * 3.3更新
 * 前端展示运动数据和监护数据页面控制
 * @author zysung
 *
 */
@Controller
@RequestMapping("/showdatas")
public class ShowDatasController {

	@Autowired
	private SportdataService sportdataService;
	@Autowired
	private CustodyService custodyService;
	@Autowired
	private UserService userService;
	/**
	 * 显示全部用户的最新运动信息列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/latestsportdatas","/sportdatas"},method=RequestMethod.GET)
	public String findAllSportdatas(Model model){
		model.addAttribute("pager", sportdataService.findAllSportdatas());
		return "showdatas/latestsportdatas";
	}
	 /**
     * 查询某用户所有运动数据
     * @param account
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/{account}/usersportdatas",method=RequestMethod.GET)
	public String findSportDatas(@PathVariable String account,Model model) throws Exception{
		model.addAttribute("pager",sportdataService.sportdataDownList(account));
		model.addAttribute("user", userService.loadUser(account));
		return "showdatas/usersportdatas";
	}
	
    /**
	 * 显示全部用户的最新监护信息列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/latestcustodydatas","/custodydatas"},method=RequestMethod.GET)
	public String findAllCustodydatas(Model model){
		model.addAttribute("pager", custodyService.findAllCustodydatas());
		return "showdatas/latestcustodydatas";
	}
	 /**
     * 查询某用户所有监护数据
     * @param account
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/{account}/usercustodydatas",method=RequestMethod.GET)
	public String findCustodyDatas(@PathVariable String account,Model model) throws Exception{
		model.addAttribute("pager",custodyService.findCustodyDatas(account));
		model.addAttribute("user", userService.loadUser(account));
		return "showdatas/usercustodydatas";
	}
	
	
	
	
	
	
}
