package cn.edu.gdin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Hospital;
import cn.edu.gdin.service.HospitalService;

/**
 * HospitalController
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午7:52:36
 * @version 1.0
 */
@Controller
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	/**
	 * 4.3更新
	 * 医院列表获取(含条件url为/hospitalList?condition=xxx)
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value="hospitalList",method=RequestMethod.GET)
	public @ResponseBody ResponseData hospitalList(String condition) throws Exception{
		ResponseData responseData = hospitalService.hospitalList(condition);
		return responseData;
	}
	 /**
		 * 4.14更新，医院logo加载
		 * @param response
		 * @param account
		 */
		@RequestMapping(value="hospitalLogo/{id}",method=RequestMethod.GET)
		public void readLogo(HttpServletResponse response,@PathVariable int id){
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
		
		
}
