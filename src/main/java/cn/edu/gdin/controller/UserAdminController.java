package cn.edu.gdin.controller;

import cn.edu.gdin.po.Doctor;
import cn.edu.gdin.po.Hospital;
import cn.edu.gdin.service.DoctorService;
import cn.edu.gdin.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value="/user")
public class UserAdminController {
	
	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value="/hospital/hospitals",method=RequestMethod.GET)
	public String findHospitals(Model model,String condition){
		model.addAttribute("pager",hospitalService.findHospitalsByCondition(condition));
		model.addAttribute("condition", condition);
		return "user/hospital/hospitals";
	}

	/**
	 * 4.7更新，后台添加
	 * @param hospital
	 * @return
	 */
	@RequestMapping(value="/hospital/add",method=RequestMethod.GET)
	public String add(Hospital hospital,Model model){
		model.addAttribute("hospital", new Hospital());
		return "hospital/add";
	}
	@RequestMapping(value="/hospital/add",method=RequestMethod.POST)
	public String add(Hospital hospital,@RequestParam String uploadImg) throws IOException{
		hospitalService.add(hospital,uploadImg);
		return "redirect:/doctor/hospital/hospitals";
	}
	/**
	 * 后台更新
	 * @param
	 * @return
	 */
	@RequestMapping(value="/hospital/{id}/update",method=RequestMethod.GET)
	public String update(Model model,@PathVariable int id){
		model.addAttribute("hospital", hospitalService.load(id));
		return "user/hospital/update";
	}
	@RequestMapping(value="/hospital/{id}/update",method=RequestMethod.POST)
	public String update(Hospital hospital,@RequestParam String uploadImg,HttpSession session){
		hospitalService.update(hospital,uploadImg);
		session.setAttribute("info", "true");
		return "redirect:/user/hospital/hospitals";
	}

	@RequestMapping(value="hospital/{id}/show",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model){
		model.addAttribute("hospital", hospitalService.load(id));
		return "user/hospital/show";
	}
	/**
	 * 4.9更新，医院logo读取
	 * @param response
	 * @param
	 */
	@RequestMapping(value="hospital/{id}/logo",method=RequestMethod.GET)
	public void readHosLogo(HttpServletResponse response,@PathVariable int id,Model model){
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



	@RequestMapping(value="/doctor/doctors",method=RequestMethod.GET)
	public String findDoctors(String condition,Model model){
		model.addAttribute("pager", doctorService.findDoctorsByCondition(condition));
		model.addAttribute("condition", condition);
		return "user/doctor/doctors";
	}
	/**
	 * 5.9更新，医生详情、更新、删除
	 */
	@RequestMapping(value="doctor/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		Doctor doctor = doctorService.load(id);
		if(doctor!=null){
			doctorService.delete(id);
		}
		return  "redirect:/user/hospital/doctor/doctors";
	}


	/**
	 * 4.9更新，医生头像读取
	 * @param response
	 * @param
	 */
	@RequestMapping(value="doctor/{id}/avatar",method=RequestMethod.GET)
	public void readLogo(HttpServletResponse response,@PathVariable int id,Model model){
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
}
