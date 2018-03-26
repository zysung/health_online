package cn.edu.gdin.service;

import java.util.List;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Pager;
import cn.edu.gdin.po.Sportdata;

/**
 * SportdataService
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:13:39
 * @version 1.0
 */
public interface SportdataService {

    ResponseData sportdataUpdate(Sportdata sportdata)throws Exception;
  //此处获取的是最新运动信息
    ResponseData sportdataDown(String userAccount)throws Exception;
    //获取用户全部运动信息
    List<Sportdata> sportdataDownList(String userAccount);
    //3.3更新 获取所有用户运动信息，用于前台展示
    Pager<Sportdata> findAllSportdatas();
}
