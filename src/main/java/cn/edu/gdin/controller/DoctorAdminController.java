package cn.edu.gdin.controller;

import cn.edu.gdin.po.*;
import cn.edu.gdin.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="/doctor")
public class DoctorAdminController {
	
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private SportdataService sportdataService;
	@Autowired
	private CustodyService custodyService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/doctor/doctors",method=RequestMethod.GET)
	public String findDoctors(String condition,Model model){
		model.addAttribute("pager", doctorService.findDoctorsByCondition(condition));
		model.addAttribute("condition", condition);
		return "doctor/doctor/doctors";
	}
	/**
	 * 4.9更新，医生头像读取
	 * @param response
	 * @param
	 */
	@RequestMapping(value="/doctor/{id}/avatar",method=RequestMethod.GET)
	public void readDoctorLogo(HttpServletResponse response,@PathVariable int id,Model model){
		Doctor  doctor =doctorService.load(id);
		try {
			if(doctor.getAvatar()!=null){
				response.getOutputStream().write(doctor.getAvatar());
				response.getOutputStream().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 医院详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="hospital/{id}/show",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model){
		model.addAttribute("hospital", hospitalService.load(id));
		return "doctor/hospital/show";
	}
	/**
	 * 4.9更新，医院logo读取
	 * @param response
	 * @param
	 */
	@RequestMapping(value="hospital/{id}/logo",method=RequestMethod.GET)
	public void readLogo(HttpServletResponse response,@PathVariable int id,Model model){
		Hospital hospital = hospitalService.load(id);
		try {
			if(hospital.getLogo()!=null){
				response.getOutputStream().write(hospital.getLogo());
				response.getOutputStream().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="hospital/hospitals",method=RequestMethod.GET)
	public String findHospitals(Model model,String condition){
		model.addAttribute("pager",hospitalService.findHospitalsByCondition(condition));
		model.addAttribute("condition", condition);
		return "doctor/hospital/hospitals";
	}

	/**
	 * 根据用户查询运动数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/data/userstosportdatas",method=RequestMethod.GET)
	public String findSportDatasByUsers(Model model,String condition,
										@RequestParam(required = false,defaultValue ="1")Integer page,
										@RequestParam(required = false,defaultValue = "6")Integer rows){

		PageHelper.startPage(page,rows);
		List<User> allList = userService.findUsersByCondition(condition);
		PageInfo<User> p  = new PageInfo<User>(allList);
		model.addAttribute("page",p);
		model.addAttribute("condition", condition);
		return "doctor/data/userstosportdatas";
	}
	/**
	 * 模糊查询
	 * @param model
	 * @param condition
	 * @return
	/**
	 * 查询某用户最新运动数据
	 * @param account
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/data/{account}/latestsportdata",method=RequestMethod.GET)
	public String getLatestSportData(@PathVariable String account,Model model) throws Exception{
		model.addAttribute("latestSportData",sportdataService.sportdataDown(account).getData());
		model.addAttribute("user", userService.loadUser(account));
		return "doctor/data/latestsportdata";
	}

	/**
	 * 查询某用户所有运动数据
	 * @param account
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/data/{account}/sportdatas",method=RequestMethod.GET)
	public String findSportDatas(@PathVariable String account,Model model,
								 @RequestParam(required = false,defaultValue ="1")Integer page,
								 @RequestParam(required = false,defaultValue = "6")Integer rows){
		PageHelper.startPage(page,rows);
		List<Sportdata> allList = sportdataService.sportdataDownList(account);
		PageInfo<Sportdata> p  = new PageInfo<Sportdata>(allList);
		model.addAttribute("page",p);
		model.addAttribute("user", userService.loadUser(account));
		return "doctor/data/sportdatas";
	}

	/*查询测试*/
	@RequestMapping(value="data/searchSportdatas",method=RequestMethod.POST)
	public String searchSportDatas(Model model,String searchVal) throws Exception{
		System.out.println(searchVal);
		model.addAttribute("datas",sportdataService.sportdataDownList(searchVal));
		return "doctor/data/sportdatas";
	}

	/**
	 * 根据用户查询监护数据
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/data/userstocustodydatas",method=RequestMethod.GET)
	public String findCustodyDatasByUsers(Model model, String condition,
										  @RequestParam(required = false,defaultValue ="1")Integer page,
										  @RequestParam(required = false,defaultValue = "6")Integer rows){

		PageHelper.startPage(page,rows);
		List<User> allList = userService.findUsersByCondition(condition);
		PageInfo<User> p  = new PageInfo<User>(allList);
		model.addAttribute("page",p);
		model.addAttribute("condition", condition);
		return "doctor/data/userstocustodydatas";
	}
	/**
	 * 模糊查询用户
	 * @param model
	 * @param condition
	 * @return
	/**
	 * 查询某用户最新监护数据
	 * @param account
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/data/{account}/latestcustodydata",method=RequestMethod.GET)
	public String getLatestCustodyData(@PathVariable String account,Model model) throws Exception{
		model.addAttribute("latestCustodyData",custodyService.custodyDataDown2(account).getData());
		model.addAttribute("user", userService.loadUser(account));
		return "doctor/data/latestcustodydata";
	}

	/**
	 * 查询某用户所有监护数据
	 * @param account
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/data/{account}/custodydatas",method=RequestMethod.GET)
	public String findCustodyDatas(@PathVariable String account,Model model,
								 @RequestParam(required = false,defaultValue ="1")Integer page,
								 @RequestParam(required = false,defaultValue = "6")Integer rows){
		PageHelper.startPage(page,rows);
		List<Custody> allList = custodyService.findCustodyDatas(account);
		PageInfo<Custody> p  = new PageInfo<Custody>(allList);
		model.addAttribute("page",p);
		model.addAttribute("user", userService.loadUser(account));
		return "doctor/data/custodydatas";
	}
}
