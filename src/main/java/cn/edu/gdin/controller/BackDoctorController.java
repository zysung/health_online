package cn.edu.gdin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.gdin.po.Doctor;
import cn.edu.gdin.service.DoctorService;

@Controller
@RequestMapping(value="/back/hospital/doctor")
public class BackDoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value="/doctors",method=RequestMethod.GET)
	public String findDoctors(String condition,Model model){
		model.addAttribute("pager", doctorService.findDoctorsByCondition(condition));
		model.addAttribute("condition", condition);
		return "back/doctor/doctors";
	}
	/**
	 * 5.9更新，医生详情、更新、删除
	 */
	@RequestMapping(value="{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		Doctor doctor = doctorService.load(id);
		if(doctor!=null){
			doctorService.delete(id);
		}
		return  "redirect:/back/hospital/doctor/doctors";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(Model model,@PathVariable int id){
		model.addAttribute("doctor", doctorService.load(id));
		return "back/doctor/update";
	}
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(Doctor doctor,@RequestParam String uploadImg){
		doctorService.update(doctor, uploadImg);
		return "redirect:/back/hospital/doctor/doctors";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Doctor doctor,Model model){
		model.addAttribute("doctor", new Doctor());
		return "back/doctor/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Doctor doctor,@RequestParam String uploadImg) throws IOException{
		doctorService.add(doctor,uploadImg);
		return "redirect:/back/hospital/hospitals";
	}
	/**
	 * 4.9更新，医生头像读取
	 * @param response
	 * @param
	 */
	@RequestMapping(value="{id}/avatar",method=RequestMethod.GET)
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
