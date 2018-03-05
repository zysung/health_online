package cn.edu.gdin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.mapper.CustodyMapper;
import cn.edu.gdin.mapper.UserMapper;
import cn.edu.gdin.po.Custody;
import cn.edu.gdin.po.Pager;
import cn.edu.gdin.po.Sportdata;
import cn.edu.gdin.po.SystemContext;
import cn.edu.gdin.po.User;
import cn.edu.gdin.service.CustodyService;

/**
 * CustodyService
 * 
 * @author wufen
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:14:36
 * @version 1.0
 */
@Service
public class CustodyServiceImpl implements CustodyService {

    @Autowired
    private CustodyMapper custodyMapper;

    @Autowired
    private UserMapper userMapper;

    @SuppressWarnings("finally")
    /**
     * 监控数据存储
     */
    @Override
    public ResponseData custodyDataUpdate(Custody custody) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setResult(false);
        responseData.setMessage("监控数据存储失败！");
        try {
            if (custody != null && custody.getUserAccount() != null) {
                custody.setCollectionTime(new Date());
                custodyMapper.insert(custody);
                responseData.setResult(true);
                responseData.setMessage("监控数据存储成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseData;
        }
    }

    /**
     * 监控数据获取
     */
    @SuppressWarnings("finally")
    @Override
    public ResponseData custodyDataDown(String userAccount) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setResult(false);
        responseData.setMessage("监控数据获取失败！");
        Custody goalCustody = new Custody();
        Date date = new Date(10L);

        try {
            User user = userMapper.selectByPrimaryKey(userAccount);
            if (user != null) {
                List<Custody> custodyList = custodyMapper.selectCustodyByUserAccount(userAccount);
                for (Custody custody : custodyList) {
                    Date collectionTime = custody.getCollectionTime();
                    if (collectionTime != null) {
                        if (collectionTime.compareTo(date) > 0) {
                            date = custody.getCollectionTime();
                            goalCustody = custody;
                        }
                    }

                }
                responseData.setResult(true);
                responseData.setMessage("监控数据获取成功！");
                responseData.setData(goalCustody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return responseData;

        }
    }
    /**
     *2.26更新， 第二种方法获取监控数据
     */
    @Override
	public ResponseData custodyDataDown2(String userAccount) throws Exception {
    	  ResponseData responseData = new ResponseData();
          responseData.setResult(false);
          responseData.setMessage("运动数据获取失败！");
          Custody goalCustodyData  = new Custody();

          User user = userMapper.selectByPrimaryKey(userAccount);
          if (user != null) {
              goalCustodyData = custodyMapper.queryMaxTime(userAccount);
              responseData.setResult(true);
              responseData.setMessage("运动数据获取成功！");
              responseData.setData(goalCustodyData);
          }
          return responseData;
    }
    /**
     * 2.26更新，分页获取用户所有监护数据
     */
	@Override
	public Pager<Custody> findCustodyDatas(String userAccount) {
		int pageSize = SystemContext.getSize();
		int pageOffest = SystemContext.getOffset();
		Pager<Custody> pages = new Pager<Custody>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userAccount", userAccount);
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffest);
		
		List<Custody> datas = custodyMapper.findCustodyByUserAccount(params);
		pages.setDatas(datas);
		pages.setOffset(pageOffest);
		pages.setSize(pageSize);
		int totalRecord = custodyMapper.findCount(params);
		pages.setTotal(totalRecord);
		return pages;
	}
	/**
	 * 3.3更新，获取所有用户最新监护信息，用于前台展示
	 */
	@Override
	public Pager<Custody> findAllCustodydatas() {
		int pageSize = SystemContext.getSize();
		int pageOffest = SystemContext.getOffset();
		Pager<Custody> pages =  new Pager<Custody>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffest);
		List<Custody> datas = custodyMapper.findAllCustodydatas(params);
		int totalRecord = custodyMapper.findAllCount();
		pages.setDatas(datas);
		pages.setOffset(pageOffest);
		pages.setSize(pageSize);
		pages.setTotal(totalRecord);
		return pages;
	}

}
