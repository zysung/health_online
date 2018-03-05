package cn.edu.gdin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Sportdata;
import cn.edu.gdin.service.SportdataService;

/**
 * SportdataController
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午8:11:08
 * @version 1.0
 */
@Controller
public class SportdataController {

    @Autowired
    private SportdataService sportdataService;

    /**
     * 运动数据存储
     * @param userAccount
     * @return
     */
    @RequestMapping(value="sportdataUpdate",method=RequestMethod.POST)
    public  @ResponseBody ResponseData sportdataUpdate(Sportdata sportdata) throws Exception{
        
        ResponseData responseData = sportdataService.sportdataUpdate(sportdata);
        return responseData;
    }
    
    /**
     * 运动数据获取
     * @param userAccount
     * @return
     * @throws Exception
     */
    @RequestMapping(value="sportdataDown",method=RequestMethod.GET)
    public @ResponseBody ResponseData sportdataDown(@RequestParam(value="userAccount")String userAccount)throws Exception{
        ResponseData responseData = sportdataService.sportdataDown(userAccount);
        return responseData;
    }
    
  

    
}
