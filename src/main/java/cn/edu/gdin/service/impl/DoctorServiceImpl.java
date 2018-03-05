package cn.edu.gdin.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Decoder;


import cn.edu.gdin.javaBean.DoctorVo;
import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.mapper.DoctorMapper;
import cn.edu.gdin.po.Doctor;
import cn.edu.gdin.po.Pager;
import cn.edu.gdin.po.SystemContext;
import cn.edu.gdin.service.DoctorService;
import cn.edu.gdin.util.MD5;

/**
 * DoctorServiceImpl
 * @author wufen        
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:15:25
 * @version 1.0
 */
@Controller
public class DoctorServiceImpl implements DoctorService{
    
    @Autowired
    private DoctorMapper doctorMapper;
    
    // 图片链接头部分
    private String image = "";

    // 图片地址
    private String location = "http://localhost/health_online/doctorAvator?validate=";

    // 混淆用户头像链接
    private String str = ".?s(*&^sjc";

    private String doctorAvatorName = "";
   
    @SuppressWarnings("finally")

    public ResponseData DoctorInfor(Integer doctorId) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("医生信息获取失败");
        responseData.setResult(false);
        DoctorVo doctorVo = new DoctorVo();
        try {
            Doctor doctor =  doctorMapper.selectByPrimaryKey(doctorId);
            if(doctor!=null){
                PropertyUtils.copyProperties(doctorVo, doctor);
                doctorVo.setAvatar(null);
                doctorAvatorName = MD5.getMD5(doctorVo.getId() + str);
                image = location + doctorAvatorName+"&doctorId="+doctorVo.getId();
                doctorVo.setDoctorAvctar(image);
                responseData.setData(doctorVo);
                responseData.setResult(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return responseData;
        }
        
    }

    @SuppressWarnings("finally")

    public byte[] doctorAvator(Integer doctorId, String validate) throws Exception {
        byte[] avatar = new byte[1024*1024*20];
        try {
            if(doctorId!=null && validate!=null&&validate!=""){
                if(MD5.getMD5(doctorId + str).equals(validate)){
                    Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                    avatar = doctor.getAvatar();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return avatar;
        }
    }
    @SuppressWarnings("finally")

    public byte[] doctorAvator(Integer doctorId) throws Exception {
        byte[] avatar = new byte[1024*1024*20];
        try {
            if(doctorId!=null){
                    Doctor doctor = doctorMapper.selectByPrimaryKey(doctorId);
                    avatar = doctor.getAvatar();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return avatar;
        }
    }
    
    /**
     * 4.6更新，实现分页
     */

	public Pager<Doctor> findDoctorsByCondition(String condition) {
		int pageSize = SystemContext.getSize();
		int pageOffset = SystemContext.getOffset();
		Pager<Doctor> pages = new Pager<Doctor>();
		Map<String , Object> params = new HashMap<String, Object>();
		if(condition!=null && !"".equals(condition)){
			condition= "%"+condition+"%";
		}
		params.put("condition", condition);
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffset);
		
		List<Doctor> datas = doctorMapper.findDoctorsHospital(params);
		int totalRecord = doctorMapper.findCount(params);
		pages.setDatas(datas);
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		pages.setTotal(totalRecord);
		return pages;
	}
	/**
	 *4.13更新，医生app接口,可有条件获取医生列表
	 */
	@SuppressWarnings("finally")

	public ResponseData doctorList(String condition) throws Exception {
		   ResponseData responseData = new ResponseData();
	        responseData.setMessage("医生信息获取失败");
	        responseData.setResult(false);
	    	Map<String , Object> params = new HashMap<String, Object>();
			if(condition!=null && !"".equals(condition)){
				condition= "%"+condition+"%";
			}
			params.put("condition", condition);
			params.put("pageSize", null);
			params.put("pageOffset", null);
	        List<Doctor> list = doctorMapper.findDoctorsHospital(params);
	        try {     	
	        	if(list != null){
	        		responseData.setResult(true);
	                responseData.setMessage("医生数据获取成功！");
	                responseData.setData(list);
	        	}      
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            return responseData;
	        }	        
	}
	
	/**
	 * 4.14更新，通过医院传医生list
	 */
	@SuppressWarnings("finally")

	public ResponseData doctorListByHospital(int hospitalId) {
		 ResponseData responseData = new ResponseData();
	        responseData.setMessage("医生信息获取失败");
	        responseData.setResult(false);
	        List<Doctor> list = doctorMapper.listByHospital(hospitalId);
	        try {     	
	        	if(list != null){
	        		responseData.setResult(true);
	                responseData.setMessage("医生数据获取成功！");
	                responseData.setData(list);
	        	}      
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            return responseData;
	        }	        
	}
	/**
	 * 5.9更新，后台医生增删查改
	 */

	public void delete(int id) {
		doctorMapper.deleteByPrimaryKey(id);
	}

	public Doctor load(int id) {
		Doctor doctor = doctorMapper.selectByPrimaryKey(id);
		return  doctor;
	}
	/**
	 * 5.9更新，后台医生更新
	 */

	public void update(Doctor doctor,String uploadImg) {
		BASE64Decoder decoder = new BASE64Decoder();    
		try {  
			/*做是否修改图片逻辑判断*/
			if(uploadImg!=null){
					String baseStr = uploadImg.substring(uploadImg.indexOf(',')+1);
			        byte[] bytes = decoder.decodeBuffer(baseStr);  
			        for (int i = 0; i < bytes.length; ++i) {
		                if (bytes[i] < 0) {// 调整异常数据
		                    bytes[i] += 256;
		                }
		            }
			        doctor.setAvatar(bytes);	
			        doctorMapper.updateByPrimaryKeyWithBLOBs(doctor);
			}else{
				doctorMapper.updateByPrimaryKey(doctor);
			}
		} catch (IOException e) {  
				e.printStackTrace();  
		}    
	}
	/**
	 * 4.3更新，后台医生添加
	 */

	public void add(Doctor doctor,String uploadImg) {
		//对前端传来的base64图片编码进行解码，变成二进制数据
		BASE64Decoder decoder = new BASE64Decoder();    
		try {  
			if(uploadImg!=null){
				String baseStr = uploadImg.substring(uploadImg.indexOf(',')+1);//对前台base64码进行裁剪，只留base64码
		        byte[] bytes = decoder.decodeBuffer(baseStr);  
		        for (int i = 0; i < bytes.length; ++i) {
	                if (bytes[i] < 0) {// 调整异常数据
	                    bytes[i] += 256;
	                }
	            }
		        doctor.setAvatar(bytes);
			}
		    doctorMapper.insert(doctor);
		} catch (IOException e) {  
		        e.printStackTrace();  
		}    
	}
	/**
	 * 获取某医院科室列表
	 */
	@SuppressWarnings("finally")

	public ResponseData expertiseListByHospital(int hospitalId) {
		 ResponseData responseData = new ResponseData();
	        responseData.setMessage("科室信息获取失败");
	        responseData.setResult(false);
	        Map<String , Object> params = new HashMap<String, Object>();
	        params.put("hospitalId", hospitalId);
	        List<String> list = doctorMapper.findExpertise(params);
	        try {     	
	        	if(list != null){
	        		responseData.setResult(true);
	                responseData.setMessage("科室数据获取成功！");
	                responseData.setData(list);
	        	}      
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            return responseData;
	        }	        
	}
	/**
	 * 通过科室获取医生列表
	 */
	@SuppressWarnings("finally")

	public ResponseData doctorListByHospitalAndExpertise(int hospitalId,String expertise) {
		 	ResponseData responseData = new ResponseData();
	        responseData.setMessage("医生列表获取失败");
	        responseData.setResult(false);
	    	Map<String , Object> params = new HashMap<String, Object>();
	    	params.put("hospitalId",hospitalId );
	    	params.put("expertise", expertise);
	        List<Doctor> list = doctorMapper.listByHospitalAndExpertise(params);
	        try {     	
	        	if(list != null){
	        		responseData.setResult(true);
	                responseData.setMessage("医生列表获取成功！");
	                responseData.setData(list);
	        	}      
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            return responseData;
	        }	        
	}
	/**
	 * 通过科室获取医生列表
	 */
	@SuppressWarnings("finally")

	public ResponseData doctorListByDisease(String disease) {
		ResponseData responseData = new ResponseData();
        responseData.setMessage("医生列表获取失败");
        responseData.setResult(false);
        if(disease!=null && !"".equals(disease)){
			disease= "%"+disease+"%";
		}
        List<Doctor> list = doctorMapper.listByDisease(disease);
        try {     	
        	if(list != null){
        		responseData.setResult(true);
                responseData.setMessage("医生列表获取成功！");
                responseData.setData(list);
        	}      
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return responseData;
        }	        
	}
	
}

