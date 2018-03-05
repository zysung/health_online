package cn.edu.gdin.mapper;

import cn.edu.gdin.po.User;
import cn.edu.gdin.po.UserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String account);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    /**
     * 实现分页
     * @param params
     * @return
     */
    List<User> findByCondition(Map<String, Object> params);
    int findCount(Map<String, Object> params);
}