package cn.edu.gdin.mapper;

import cn.edu.gdin.po.Custody;
import cn.edu.gdin.po.CustodyExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustodyMapper {
    int countByExample(CustodyExample example);

    int deleteByExample(CustodyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Custody record);

    int insertSelective(Custody record);

    List<Custody> selectByExample(CustodyExample example);

    Custody selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Custody record, @Param("example") CustodyExample example);

    int updateByExample(@Param("record") Custody record, @Param("example") CustodyExample example);

    int updateByPrimaryKeySelective(Custody record);

    int updateByPrimaryKey(Custody record);
    
    //通过UserAccount查询所有监控信息
    List<Custody> selectCustodyByUserAccount(String userAccount);
    //通过UserAccount查询最新监控信息
    Custody queryMaxTime(String custodyId);
    //通过UserAccount分页查询所有运动信息  直接在sql中拼接子查询 2.26更新
    List<Custody> findCustodyByUserAccount(Map<String, Object> params);
    int findCount(Map<String, Object> params);
  //3.3更新，查询所有用户监护信息，用于前台展示
    List<Custody> findAllCustodydatas(Map<String, Object> params);
    int findAllCount();
}