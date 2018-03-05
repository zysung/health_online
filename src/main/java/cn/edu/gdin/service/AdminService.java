package cn.edu.gdin.service;

import cn.edu.gdin.javaBean.ResponseData;
import cn.edu.gdin.po.Admin;

public interface AdminService {
	
	public ResponseData login(String adminName, String password);
	public ResponseData regist(Admin admin);
	public Admin loadByName(String adminName);
	
}
