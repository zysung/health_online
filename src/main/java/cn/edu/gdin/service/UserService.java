package cn.edu.gdin.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Pager;
import cn.edu.gdin.po.User;

/**
 * UserService
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月6日 上午10:29:58
 * @version 1.0
 */
public interface UserService {
	/*
	 * 使用RespomseData 对象返回 json
	 */
    public ResponseData login(String account, String password)throws Exception;

    public byte[] accountAvator(String accountId, String validate) throws Exception;

    public ResponseData regist(User user, MultipartFile avator)throws Exception;

    public ResponseData userInforDown(String account)throws Exception;

    public ResponseData resetPwd(String account)throws Exception;

    public ModelAndView resetPwd2(String account, String validateCode)throws Exception;

    public ModelAndView resetPwd3(String account, String validateCode, String password)throws Exception;
  
    
    
    /**
     * 2.25更新,做出网页使用接口
     */
    public User loadUser(String account);
    
    public void deleteUser(String account);
    /**
     * 
     *  获取分页对象
     * @param condition
     * @return
     */
    public Pager<User> findUsersByCondition(String condition);
    
    public Pager<User> findUsers();
}
