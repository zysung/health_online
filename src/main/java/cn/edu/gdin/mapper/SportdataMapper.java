package cn.edu.gdin.mapper;

import cn.edu.gdin.po.Sportdata;
import cn.edu.gdin.po.SportdataExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SportdataMapper {
    int countByExample(SportdataExample example);

    int deleteByExample(SportdataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sportdata record);

    int insertSelective(Sportdata record);

    List<Sportdata> selectByExample(SportdataExample example);

    Sportdata selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sportdata record, @Param("example") SportdataExample example);

    int updateByExample(@Param("record") Sportdata record, @Param("example") SportdataExample example);

    int updateByPrimaryKeySelective(Sportdata record);

    int updateByPrimaryKey(Sportdata record);
    
    //通过UserAccount查询最新运动信息  取出该用户的所有信息  再筛选
    List<Sportdata> selectSportdataByUserAccount1(String userAccount);
    //通过UserAccount查询最新运动信息  直接在sql中拼接子查询
    Sportdata selectSportdataByUserAccount(String userAccount);
  //通过UserAccount分页查询所有运动信息  直接在sql中拼接子查询 2.25更新
    List<Sportdata> findSportdataByUserAccount(Map<String, Object> params);
    int findCount(Map<String, Object> params);
    //3.3更新，查询所有用户运动信息，用于前台展示
    List<Sportdata> findAllSportdatas(Map<String, Object> params);
    int findAllCount();
    
    
   
}