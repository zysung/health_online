package cn.edu.gdin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.mapper.SportdataMapper;
import cn.edu.gdin.mapper.UserMapper;
import cn.edu.gdin.po.Pager;
import cn.edu.gdin.po.Sportdata;
import cn.edu.gdin.po.SystemContext;
import cn.edu.gdin.po.User;
import cn.edu.gdin.service.SportdataService;

/**
 * SpaortdataServiceImpl
 * 
 * @author wufen
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:16:38
 * @version 1.0
 */
@Service
public class SportdataServiceImpl implements SportdataService {

    @Autowired
    private SportdataMapper sportdataMapper;

    @Autowired
    private UserMapper userMapper;

    @SuppressWarnings("finally")
    public ResponseData sportdataUpdate(Sportdata sportdata) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("运动数据存储失败");
        responseData.setResult(false);
        try {
            sportdata.setCollectionTime(new Date());
            sportdataMapper.insert(sportdata);
            responseData.setMessage("运动数据存储成功");
            responseData.setResult(true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseData;
        }

    }

    public ResponseData sportdataDown(String userAccount) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setResult(false);
        responseData.setMessage("运动数据获取失败！");
        Sportdata goalSportdata = new Sportdata();
        //Date date = new Date(10L);

        User user = userMapper.selectByPrimaryKey(userAccount);
        if (user != null) {
            /*List<Sportdata> sportdataList = sportdataMapper.selectSportdataByUserAccount(userAccount);
            for (Sportdata sportdata : sportdataList) {
                Date collectionTime = sportdata.getCollectionTime();
                if (collectionTime != null) {
                    if (collectionTime.compareTo(date) > 0) {
                        date = sportdata.getCollectionTime();
                        goalSportdata = sportdata;
                    }
                }

            }*/
        	//此处获取的是最新运动信息
            goalSportdata = sportdataMapper.selectSportdataByUserAccount(userAccount);
            responseData.setResult(true);
            responseData.setMessage("运动数据获取成功！");
            responseData.setData(goalSportdata);
        }

        return responseData;
    }
    /**
     *2.25 更新，list获取一个用户全部运动数据
     */
	public List<Sportdata> sportdataDownList(String userAccount) {
		List<Sportdata> sdl = sportdataMapper.selectSportdataByUserAccount1(userAccount); 
		return sdl;
	}

	/**
	 * 3.3更新，获取所有用户运动信息，用于前台展示
	 */
	public Pager<Sportdata> findAllSportdatas() {
		int pageSize = SystemContext.getSize();
		int pageOffest = SystemContext.getOffset();
		Pager<Sportdata> pages =  new Pager<Sportdata>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffest);
		List<Sportdata> datas = sportdataMapper.findAllSportdatas(params);
		int totalRecord = sportdataMapper.findAllCount();
		pages.setDatas(datas);
		pages.setOffset(pageOffest);
		pages.setSize(pageSize);
		pages.setTotal(totalRecord);
		return pages;
	}

}
