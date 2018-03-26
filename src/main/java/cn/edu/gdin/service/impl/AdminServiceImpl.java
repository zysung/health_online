package cn.edu.gdin.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.mapper.AdminMapper;
import cn.edu.gdin.po.Admin;
import cn.edu.gdin.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper  adminMapper;
	
	@SuppressWarnings("finally")

	public ResponseData login(String adminName, String password) {
		ResponseData responseData = new ResponseData();
        responseData.setResult(false);
        responseData.setMessage("不存在该用户！");
        Admin admin = adminMapper.selectByAdminName(adminName);
        try {
            if (admin != null) {
                    if (admin.getAdminPassword().equals(password)) {
                    	responseData.setData(admin);
                        responseData.setResult(true);
                        responseData.setMessage("登录成功！");
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

	@SuppressWarnings("finally")

	public ResponseData regist(Admin admin) {
		ResponseData responseData = new ResponseData();
        responseData.setResult(false);
        responseData.setMessage("注册失败！");
        Admin a = adminMapper.selectByPrimaryKey(admin.getAdminId());
        try {
            if (a != null) {
            	responseData.setResult(false);
                responseData.setMessage("该用户已存在");
            }
            else{
            	adminMapper.insert(admin);
            	responseData.setResult(true);
                responseData.setMessage("注册成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return responseData;
        }
	}


	public Admin loadByName(String adminName) {
		Admin admin = adminMapper.selectByAdminName(adminName);
		return admin;
	}

}
