package cn.edu.gdin.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.User;
import cn.edu.gdin.service.UserService;

/**
 * UserController
 * 
 * @author wufen
 * @email wufen@163.com
 * @date 2016年12月8日 下午7:49:49
 * @version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService UserService;

    /**
     * 用户登录
     * 
     * @param accountId
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login")
    public @ResponseBody ResponseData login(@RequestParam(value = "account") String account,
            @RequestParam(value = "password") String password) throws Exception {

        ResponseData responseData = UserService.login(account, password);
        return responseData;
    }

    /**
     * 用户登录加载头像
     * 
     * @param accountId
     * @throws Exception
     */
    @RequestMapping(value = "accountAvator")
    public void accountAvator(@RequestParam(value = "account") String account,
            @RequestParam(value = "validate") String validate, HttpServletResponse response) throws Exception {

        byte[] avatar = UserService.accountAvator(account, validate);
        response.getOutputStream().write(avatar);
    }

    /**
     * 用户注册
     * 
     * @param user
     * @param avator
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public @ResponseBody ResponseData regist(User user, MultipartFile Useravatar) throws Exception {
        System.out.println(user.getBirthday());
        ResponseData responseData = UserService.regist(user, Useravatar);
        return responseData;
    }

    /**
     * 用户个人资料(获取)
     * 
     * @param account
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "userInforDown", method = RequestMethod.GET)
    public @ResponseBody ResponseData userInforDown(@RequestParam(value = "account") String account)
            throws Exception {

        ResponseData responseData = UserService.userInforDown(account);
        return responseData;
    }
    
    /**
     * 密码重置
     * @param account
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "resetPwd", method = RequestMethod.GET)
    public @ResponseBody ResponseData resetPwd(@RequestParam(value = "account") String account)throws Exception{
        ResponseData responseData = UserService.resetPwd(account);
        return responseData;
    }

    /**
     * 密码重置
     * @param account
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "resetPwd2", method = RequestMethod.GET)
    public ModelAndView resetPwd2(@RequestParam(value = "account") String account,@RequestParam(value = "validateCode") String validateCode)throws Exception{
        ModelAndView modelAndView = UserService.resetPwd2(account,validateCode);
        return modelAndView;
    }
    
    /**
     * 密码重置
     * @param account
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "resetPwd3", method = RequestMethod.POST)
    public ModelAndView resetPwd3(@RequestParam(value = "account") String account,@RequestParam(value = "validateCode") String validateCode,@RequestParam(value = "password") String password)throws Exception{
        ModelAndView modelAndView = UserService.resetPwd3(account,validateCode,password);
        return modelAndView;
    }
    
    
}
