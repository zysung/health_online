package cn.edu.gdin.mapper;

import cn.edu.gdin.po.Hospital;
import cn.edu.gdin.po.HospitalExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalMapper {
    int countByExample(HospitalExample example);

    int deleteByExample(HospitalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hospital record);

    int insertSelective(Hospital record);

    List<Hospital> selectByExampleWithBLOBs(HospitalExample example);

    List<Hospital> selectByExample(HospitalExample example);

    Hospital selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByExampleWithBLOBs(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByExample(@Param("record") Hospital record, @Param("example") HospitalExample example);

    int updateByPrimaryKeySelective(Hospital record);

    int updateByPrimaryKeyWithBLOBs(Hospital record);

    int updateByPrimaryKey(Hospital record);
    
    Hospital selectByName(String hospitalName);
    /**
     * 3.1更新
     * 实现分页
     * @param params
     * @return
     */
    List<Hospital> findByCondition(Map<String, Object> params);
    int findCount(Map<String, Object> params);
}