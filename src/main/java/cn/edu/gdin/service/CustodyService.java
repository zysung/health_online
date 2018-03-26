package cn.edu.gdin.service;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Custody;
import cn.edu.gdin.po.Pager;

import java.util.List;

/**
 * CustodyService
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月6日 上午10:29:26
 * @version 1.0
 */
public interface CustodyService {

    ResponseData custodyDataUpdate(Custody custody)throws Exception;
    //此处获取用户最新监护信息
    ResponseData custodyDataDown(String userAccount)throws Exception;
    //第二种方法实习获取最新监护信息，用sql
    ResponseData custodyDataDown2(String userAccount)throws Exception;
    //获取用户的全部监护信息
    List<Custody> findCustodyDatas(String userAccount);
  //3.3更新 获取所有用户运动信息，用于前台展示
    Pager<Custody> findAllCustodydatas();
}
