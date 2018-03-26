package cn.edu.gdin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.mapper.UserMapper;
import cn.edu.gdin.po.Pager;
import cn.edu.gdin.po.SystemContext;
import cn.edu.gdin.po.User;
import cn.edu.gdin.service.UserService;
import cn.edu.gdin.util.EmailSender;
import cn.edu.gdin.util.MD5;


/**
 * UserServiceImpl
 * @author wufen        
 * @email wufen@163.com
 * @date 2016年12月6日 上午10:33:47
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private EmailSender emailSender;
  
    @Value("${email_mimetype}")
    private String email_mimetype;
    
    @Value("${resetPwd2_url}")
    private String resetPwd2_url;
    
    private String email_subject = "健康在线-找回密码";
    
    // 图片链接头部分
    private String image = "";
    
    private String content1 = "<tr><td><span class='cntext'>尊敬的客户：";
    private String content2 = "<br>&nbsp; &nbsp; &nbsp; &nbsp; 您好！感谢您对健康在线的信任与支持！"
            + "<br>&nbsp; &nbsp; &nbsp; &nbsp; <font color='red'>您需要通过下面的链接设置您的新密码</font>：<br><span class='cntext'>&nbsp; "
            + "<strong>链接</strong></span>：<br>";
    private String content3 = "<a  href='";//+resetPwd2_url
    private String content4 = "&validateCode=";
    private String content5 = "'>";//+resetPwd2_url;
    private String content6 = "&validateCode=";
    private String content7 = "</a><br/>如果您不能点击以上链接，请将该链接复制到浏览器地址栏中访问，也可以完成新密码的创建！<br><table width='100%' border='0' align='center' cellpadding='0' cellspacing='0'>"
            + "<tr><td height='20'>本电子邮件是由系统自动发送，如您有事需要询问或帮助，请与我们取得联系!"
            + "<hr size='1' color='#D2DDED' noshade></td></tr> </table></tr>";
    
    // 图片地址
    @Value("${avatar_url}")
    private String location ;

    private String content3_str = "";
    private String content5_str = "";
    
    // 混淆用户头像链接
    @Value("${avatar_confuse_str}")
    private String str ;//= ".?s(*&^sjc";

    private String accountAvatorName = "";
    
    @SuppressWarnings("finally")

    public ResponseData resetPwd(String account) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("密码重置失败！");
        responseData.setResult(false);
        content3_str =  content3+resetPwd2_url;
        content5_str = content5+resetPwd2_url;
        try {
            if (account != null && !"".equals(account.trim())) {
                StringBuffer content = new StringBuffer();
                User user = userMapper.selectByPrimaryKey(new String(account.getBytes("iso-8859-1"), "utf-8"));
                if (user != null && !"".equals(user.getEmail().trim())) {
                    String validateCode = MD5.getMD5(user.getAccount()+ user.getPassword());
                    content = content.append(content1).append(user.getAccount()).append(content2).append(content3_str);
                    content = content.append(user.getAccount()).append(content4).append(validateCode).append(content5_str).append(user.getAccount());
                    content.append(content6).append(validateCode).append(content7);
                    /*Properties properties = new Properties();
                    properties.setProperty("resource.loader", "file");
                    properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
                    VelocityEngine velocityEngine = new VelocityEngine(properties);
                   VelocityContext context = new VelocityContext();
                    context.put("account", "wufen");
                    context.put("validateCode", MD5.getMD5("wuu"));
                    StringWriter writer = new StringWriter();
                    //velocityEngine.mergeTemplate("mailContent.vm", "gbk", context, writer);
                    //System.out.println(writer.toString());
                    File file = new File("C:\\Users\\ASUS\\Desktop\\mailContent.vm");
                    FileInputStream frileReader = new FileInputStream(file);
                    byte[] b = new byte[(int) file.length()];
                   // String content = rileReader.toString();
                    frileReader.read(b);*/
                    //String content = writer.toString();
                    //EmailSender emailSender = new EmailSender();
                    String eamil = user.getEmail();
                    emailSender.send(eamil, email_subject, content.toString(), email_mimetype);
                    
                    System.out.println(content.toString());
                    responseData.setMessage("密码重置已发送到您注册的邮箱，请前往该邮箱继续下一步操作！");
                    responseData.setResult(true);
                   
                }else{
                    responseData.setMessage("该用户不存在！");
                }
            }else{
                responseData.setMessage("请输入用户名！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseData;
    }
    

    public ModelAndView resetPwd2(String account, String validateCode) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if(account!=null&&validateCode!=null){
            User user = userMapper.selectByPrimaryKey(new String(account.getBytes("iso-8859-1"), "utf-8"));
            if(user!=null&&MD5.getMD5(user.getAccount()+ user.getPassword()).equals(validateCode)){
                modelAndView.addObject("account", account);
                modelAndView.addObject("validateCode",validateCode);
                modelAndView.setViewName("findPassword3");
            }
            
        }
        return modelAndView;
    }
    

    public ModelAndView resetPwd3(String account, String validateCode, String password) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if(account!=null&&validateCode!=null&&password!=null){
            User user = userMapper.selectByPrimaryKey(new String(account.getBytes("iso-8859-1"), "utf-8"));
            if(user!=null&&MD5.getMD5(user.getAccount()+ user.getPassword()).equals(validateCode)){
                user.setPassword(MD5.getMD5(password));
                userMapper.updateByPrimaryKey(user);
                modelAndView.addObject("message", "<font color='red'>密码修改成功！</font>");
                modelAndView.setViewName("findPassword3");
            }
            
        }
        return modelAndView;
    }


    @SuppressWarnings("finally")

    public ResponseData login(String account, String password){
        ResponseData responseData = new ResponseData();
        responseData.setResult(false);
        responseData.setMessage("不存在该用户！");
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userMapper.selectByPrimaryKey(account);
        try {
            if (user != null) {
                    if (user.getPassword().equals(password)) {
                        accountAvatorName = MD5.getMD5(account + str);
                        image = location + accountAvatorName+"&account="+account;
                        map.put("accountId", user.getAccount());
                        map.put("avator", image);
                        responseData.setResult(true);
                        responseData.setMessage("登录成功！");
                        responseData.setData(map);
                    } else {
                        responseData.setResult(false);
                        responseData.setMessage("用户名或密码错误");
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return responseData;
        }
    }


    public byte[] accountAvator(String accountId, String validate) {
        byte[] avatar = new byte[1024*1024*20];
        try {
            if(MD5.getMD5(accountId + str).equals(validate)){
                User user = userMapper.selectByPrimaryKey(accountId);
                avatar = user.getAvatar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avatar;
    }

    @SuppressWarnings("finally")

    public ResponseData regist(User user, MultipartFile avator){
        ResponseData responseData = new ResponseData();
        responseData.setMessage("注册失败！");
        responseData.setResult(false);
        try {
            if(user!=null){
                user.setAvatar(avator.getBytes());
                user.setPassword(MD5.getMD5(user.getPassword()));
                user.setBirthday(user.getBirthday());
               // Date date = new Date(user.getBirthday().getYear(), user.getBirthday().getMonth(), user.getBirthday().getDate());
               // user.setBirthday(new Date());
                userMapper.insert(user);
                responseData.setData(user.getAccount());
                responseData.setResult(true);
                responseData.setMessage("注册成功！");
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return responseData;
        }
    }

    @SuppressWarnings("finally")

    public ResponseData userInforDown(String account) throws Exception {
        ResponseData responseData = new ResponseData();
        responseData.setMessage("个人资料获取失败");
        responseData.setResult(false);
        try {
            User user = userMapper.selectByPrimaryKey(new String(account.getBytes("iso-8859-1"),"utf-8"));
            if(user!=null){
                user.setAvatar(null);
                user.setPassword(null);
                //String date = new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday());
                responseData.setData(user);
                responseData.setResult(true);
                responseData.setMessage("个人资料获取成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return responseData;
        }
    }
    /**
     * 2.25更新
     * 获取分页对象，以及不转码的获取user
     */

	public List<User> findUsersByCondition(String condition) {

		Map<String, Object> params = new HashMap<String, Object>();
		if(condition!=null && !"".equals(condition)){
			condition= "%"+condition+"%";
		}
		params.put("condition", condition);

		List<User> datas = userMapper.findByCondition(params);
		return datas;
	}


	public Pager<User> findUsers() {
		int pageSize = SystemContext.getSize();
		int pageOffest = SystemContext.getOffset();
		Pager<User> pages = new Pager<User>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffest);
		
		List<User> datas = userMapper.findByCondition(params);
		pages.setDatas(datas);
		pages.setOffset(pageOffest);
		pages.setSize(pageSize);
		int totalRecord = userMapper.findCount(params);
		pages.setTotal(totalRecord);
		return pages;
	}


	public User loadUser(String account) {
		User user = userMapper.selectByPrimaryKey(account);
		return user;
	}
	//简单实现，待用responseData改进

	public void deleteUser(String account) {
		userMapper.deleteByPrimaryKey(account);
	}

    

  
}
