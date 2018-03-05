package cn.edu.gdin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Custody;
import cn.edu.gdin.service.CustodyService;

/**
 * CustodyController
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午7:52:11
 * @version 1.0
 */
@Controller
public class CustodyController {
    @Autowired
    private CustodyService custodyService;
    
    @RequestMapping(value="custodyDataUpdate",method=RequestMethod.POST)
    public @ResponseBody ResponseData custodyDataUpdate(Custody custody) throws Exception{
        ResponseData responseData = custodyService.custodyDataUpdate(custody);
        return responseData;
    }

    @RequestMapping(value="custodyDataDown",method=RequestMethod.GET)
    public @ResponseBody ResponseData custodyDataDown(@RequestParam(value="userAccount")String userAccount) throws Exception{
        ResponseData responseData = custodyService.custodyDataDown(userAccount);
        return responseData;
    }

}
