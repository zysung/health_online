package cn.edu.gdin.mapper;

import cn.edu.gdin.po.Doctor;
import cn.edu.gdin.po.DoctorExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorMapper {
    int countByExample(DoctorExample example);

    int deleteByExample(DoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    List<Doctor> selectByExampleWithBLOBs(DoctorExample example);

    List<Doctor> selectByExample(DoctorExample example);

    Doctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExampleWithBLOBs(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByExample(@Param("record") Doctor record, @Param("example") DoctorExample example);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKeyWithBLOBs(Doctor record);

    int updateByPrimaryKey(Doctor record);
    
    /**
     * 4.6更新，实现分页
     */
    List<Doctor> findByCondition(Map<String, Object> params);
    int findCount(Map<String, Object> params);
    /**
     * 测试多对一关联查询
     * @param params
     * @return
     */
    List<Doctor> findDoctorsHospital(Map<String, Object> params);
    /**
     * 通过医院ID查询医生列表
     * @param hospitalId
     * @return
     */
    List<Doctor> listByHospital(Integer hospitalId);
    /**
     * 通过医院id查医院所有科室
     * @param hospitalId
     * @return
     */
    List<String> findExpertise(Map<String, Object> params);
    /**
     * 通过科室查询医生列表
     * @param expertise
     * @return
     */
    List<Doctor> listByHospitalAndExpertise(Map<String, Object> params);
    /**
     * 通过疾病查询医生
     * @param disease
     * @return
     */
    List<Doctor> listByDisease(String disease);
    
}