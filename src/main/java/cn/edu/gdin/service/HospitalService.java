package cn.edu.gdin.service;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Hospital;
import cn.edu.gdin.po.Pager;

/**
 * HospitalService
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:13:00
 * @version 1.0
 */
public interface HospitalService {
	/**
	 * 3.1更新获取分页对象
	 * @param condition
	 * @return
	 */
	Pager<Hospital> findHospitalsByCondition(String condition);
	Pager<Hospital> findHospitals();
	/**
	 * 3.30更新，安卓接口，传医院list
	 * @param hospitalId
	 * @return
	 * @throws Exception
	 */
	ResponseData hospitalList(String condition) throws Exception;
	/**
	 * 4.3更新，医院增查改
	 */
	public void add(Hospital hospital, String uploadImg);
	public void update(Hospital hospital, String uploadImg);
	public void delete(int id);
	public Hospital load(int id);
	public Hospital load(String hospitalName);
	
}
