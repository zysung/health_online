package cn.edu.gdin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Encoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.edu.gdin.po.Admin;
import cn.edu.gdin.po.Hospital;
import cn.edu.gdin.service.HospitalService;

@Controller
@RequestMapping(value="/back/hospital")
public class BackHospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping(value="/hospitals",method=RequestMethod.GET)
	public String findHospitals(Model model,String condition){
		model.addAttribute("pager",hospitalService.findHospitalsByCondition(condition));
		model.addAttribute("condition", condition);
		return "back/hospital/hospitals";
	}
	
/*	@RequestMapping(value="/searchHospitals",method=RequestMethod.POST)
	public String findByCondition(Model model,String condition){
		model.addAttribute("pager", hospitalService.findHospitalsByCondition(condition));
		model.addAttribute("condition",condition);
		return "back/searchhospitals";
	}*/
	/**
	 * 4.7更新，后台添加
	 * @param hospital
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Hospital hospital,Model model){
		model.addAttribute("hospital", new Hospital());
		return "hospital/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Hospital hospital,@RequestParam String uploadImg) throws IOException{
		hospitalService.add(hospital,uploadImg);
		return "redirect:/back/hospital/hospitals";
	}
	/**
	 * 后台更新
	 * @param hospital
	 * @return
	 */
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(Model model,@PathVariable int id){
		model.addAttribute("hospital", hospitalService.load(id));
		return "back/hospital/update";
	}
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(Hospital hospital,@RequestParam String uploadImg,HttpSession session){
		hospitalService.update(hospital,uploadImg);
		session.setAttribute("info", "true");
		return "redirect:/back/hospital/hospitals";
	}
	@RequestMapping(value="{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		Hospital hospital = hospitalService.load(id);
		if(hospital != null){
			hospitalService.delete(id);
		}
		return  "redirect:/back/hospital/hospitals";
	}
	@RequestMapping(value="{id}/show",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model){
		model.addAttribute("hospital", hospitalService.load(id));
		return "back/hospital/show";
	}
	/**
	 * 4.9更新，医院logo读取
	 * @param response
	 * @param account
	 */
	@RequestMapping(value="{id}/logo",method=RequestMethod.GET)
	public void readLogo(HttpServletResponse response,@PathVariable int id,Model model){
		Hospital  hospital = hospitalService.load(id);
		try {
			if(hospital.getLogo()!=null){
				response.getOutputStream().write(hospital.getLogo());
				response.getOutputStream().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ajax验证医院名重复
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/checkHospitalName",method=RequestMethod.POST)
	public @ResponseBody boolean checkHospitalName(HttpServletRequest req){
		boolean valid = true;
		String hospitalName = req.getParameter("name");
		System.out.println(hospitalName);
		Hospital hospital = hospitalService.load(hospitalName);
		if(hospital!=null){
			valid  = false;
		}
		return valid;
	}
	
}
