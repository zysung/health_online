package cn.edu.gdin.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.mapper.HospitalMapper;
import cn.edu.gdin.po.Hospital;
import cn.edu.gdin.po.Pager;
import cn.edu.gdin.po.SystemContext;
import cn.edu.gdin.service.HospitalService;

/**
 * HospitalServiceImpl
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:16:07
 * @version 1.0
 */
@Service
public class HospitalServiceImpl implements HospitalService {
	@Autowired(required = false)
	private HospitalMapper hospitalMapper;
	
	/**
	 * 4.7更新，后台医院更新,删除
	 */

	public void update(Hospital hospital,String uploadImg) {
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
			        hospital.setLogo(bytes);	
			        hospitalMapper.updateByPrimaryKeyWithBLOBs(hospital);
			}else{
				hospitalMapper.updateByPrimaryKey(hospital);
			}
		} catch (IOException e) {  
				e.printStackTrace();  
		}    
	}


	public void delete(int id) {
		hospitalMapper.deleteByPrimaryKey(id);
	}

	public Hospital load(int id) {
		Hospital hospital  = hospitalMapper.selectByPrimaryKey(id);
		return hospital;
	}

	/**
	 * 4.3更新，后台医院添加
	 */

	public void add(Hospital hospital,String uploadImg) {
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
		        hospital.setLogo(bytes);
			}
		    hospitalMapper.insert(hospital);
		} catch (IOException e) {  
		        e.printStackTrace();  
		}    
	}
	
	
	/**
	 * 3.30更新，医院app接口
	 */
	  @SuppressWarnings("finally")

	    public ResponseData hospitalList(String condition) throws Exception {
	        ResponseData responseData = new ResponseData();
	        responseData.setMessage("医院信息获取失败");
	        responseData.setResult(false);
	        Map<String, Object> params = new HashMap<String, Object>();
			if(condition!=null && !"".equals(condition)){
				condition= "%"+condition+"%";
			}
			params.put("condition", condition);
			params.put("pageSize",null);
			params.put("pageOffset", null);
	        List<Hospital> list = hospitalMapper.findByCondition(params);
	        try {     	
	        	if(list != null){
	        		responseData.setResult(true);
	                responseData.setMessage("医院数据获取成功！");
	                responseData.setData(list);
	        	}      
	        } catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            return responseData;
	        }	        
	    }
	
	
	/**
	 * 3.1更新，分页对象获取
	 */

	public Pager<Hospital> findHospitalsByCondition(String condition) {
		int pageSize = SystemContext.getSize();
		int pageOffset = SystemContext.getOffset();
		Pager<Hospital> pages = new Pager<Hospital>();
		Map<String, Object> params = new HashMap<String, Object>();
		if(condition!=null && !"".equals(condition)){
			condition= "%"+condition+"%";
		}
		params.put("condition", condition);
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffset);
		
		List<Hospital> datas = hospitalMapper.findByCondition(params);
		int totalRecord = hospitalMapper.findCount(params);
		pages.setDatas(datas);
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		pages.setTotal(totalRecord);
		return pages;
	}


	public Pager<Hospital> findHospitals() {
		int pageSize = SystemContext.getSize();
		int pageOffest = SystemContext.getOffset();
		Pager<Hospital> pages = new Pager<Hospital>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffest);
		
		List<Hospital> datas = hospitalMapper.findByCondition(params);
		int totalRecord = hospitalMapper.findCount(params);
		pages.setDatas(datas);
		pages.setOffset(pageOffest);
		pages.setSize(pageSize);
		pages.setTotal(totalRecord);
		return pages;
	}


	public Hospital load(String hospitalName) {
		Hospital hospital = hospitalMapper.selectByName(hospitalName);
		return hospital;
	}

	




}
