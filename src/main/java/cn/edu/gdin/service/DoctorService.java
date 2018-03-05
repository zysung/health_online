package cn.edu.gdin.service;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Doctor;
import cn.edu.gdin.po.Hospital;
import cn.edu.gdin.po.Pager;

/**
 * DoctorService
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:13:15
 * @version 1.0
 */
public interface DoctorService {

    ResponseData DoctorInfor(Integer doctorId)throws Exception;

    byte[] doctorAvator(Integer doctorId, String validate)throws Exception;
	byte[] doctorAvator(Integer doctorId) throws Exception;
    /**
     * 4.14更新，安卓接口，按医院传医生list
     */
    ResponseData doctorListByHospital(int hospitalId);
    /**
     * 4.13更新，安卓接口，传医生list
     * @return
     * @throws Exception
     */
    ResponseData doctorList(String condition) throws Exception;
    /**
     * 5.15更新，安卓接口，根据医院id传某医院所有科室列表
     * @param hospitalId
     * @return
     */
    ResponseData expertiseListByHospital(int hospitalId);
    /**
     * 安卓接口，根据医院科室传医生列表
     * @param hospitalId
     * @param expertise
     * @return
     */
    ResponseData doctorListByHospitalAndExpertise(int hospitalId, String expertise);
    /**
     * 安卓接口，根据疾病传某医院医生列表
     * @param disease
     * @return
     */
    ResponseData doctorListByDisease(String disease);
    /**
	 * 4.6更新获取分页对象
	 * @param condition
	 * @return
	 */
	Pager<Doctor> findDoctorsByCondition(String condition);
	public void add(Doctor doctor, String uploadImg);
	public void update(Doctor doctor, String uploadImg);
	public void delete(int id);
	public Doctor load(int id);

}
