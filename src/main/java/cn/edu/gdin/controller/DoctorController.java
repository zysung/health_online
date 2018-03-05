package cn.edu.gdin.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.service.DoctorService;

/**
 * DoctorController
 * @author zysung	
 * @email songziyang95@126.com
 * @date 2017年6月1日 下午8:11:46
 * @version 3.0
 */
@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    
    /**
     * 医生信息获取
     * @param doctorId
     * @return
     * @throws Exception
     */
    @RequestMapping(value="DoctorInfor",method=RequestMethod.GET)
    public @ResponseBody ResponseData DoctorInfor(@RequestParam(value="doctorId")Integer doctorId)throws Exception{
        
        ResponseData responseData = doctorService.DoctorInfor(doctorId);
        return responseData;
        
    }
    /**
	 * 4.13更新
	 * 医生列表获取,app接口
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping(value="doctorList",method=RequestMethod.GET)
	public @ResponseBody ResponseData doctorList(String condition) throws Exception{
		ResponseData responseData =doctorService.doctorList(condition);
		return responseData;
	}
	 /**
	  * 5.1更新
	  * 通过医院id获取医生列表
	  * @param hospitalId
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="doctorListByHospital",method=RequestMethod.GET)
	 public @ResponseBody ResponseData doctorListByHospital(int hospitalId) throws Exception{
		 ResponseData responseData = doctorService.doctorListByHospital(hospitalId);
		 return responseData;
	 }
	 /**
	  * 根据医院id查询科室列表
	  * @param hospitalId
	  * @return
	  */
	 @RequestMapping(value="expertiseListByHospital",method=RequestMethod.GET)
	 public @ResponseBody ResponseData expertiseListByHospital(int hospitalId) throws Exception{
		 ResponseData responseData = doctorService.expertiseListByHospital(hospitalId);
		 return responseData;
	 }
	
	 /**
	  * 通过科室获取医生列表（调用方式doctorListByExpertise?hospitalId=xx&&expertise=xxxx）
	  * @param hospitalId
	  * @param expertise
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="doctorListByExpertise",method=RequestMethod.GET)
	 public @ResponseBody ResponseData expertiseListByHospital(int hospitalId,String expertise) throws Exception{
		 ResponseData responseData = doctorService.doctorListByHospitalAndExpertise(hospitalId, expertise);
		 return responseData;
	 }
	 
    /**
     * 医生加载头像
     * @param accountId
     * @throws Exception 
     */
    @RequestMapping(value="doctorAvator")
    public void doctorAvator(@RequestParam(value="doctorId")Integer doctorId,HttpServletResponse response) throws Exception{
        byte[] avatar = doctorService.doctorAvator(doctorId);
        response.getOutputStream().write(avatar);
    }
    /**
	  * 通过疾病获取医生列表
	  * @param hospitalId
	  * @param expertise
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="doctorListByDisease",method=RequestMethod.GET)
	 public @ResponseBody ResponseData doctorListByDisease(String disease) throws Exception{
		 ResponseData responseData = doctorService.doctorListByDisease(disease);
		 return responseData;
	 }
	 /**
	  * 查询医生的所有科室列表
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value="expertiseList",method=RequestMethod.GET)
	 public @ResponseBody ResponseData allExpertiseList() throws Exception{
		 ResponseData responseData = doctorService.expertiseListByHospital(0);
		 return responseData;
	 }
    
    
}
