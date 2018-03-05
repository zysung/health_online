package cn.edu.gdin.javaBean;

import cn.edu.gdin.po.Doctor;

/**
 * DoctorVo
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月9日 上午10:24:37
 * @version 1.0
 */
public class DoctorVo extends Doctor{
	private String doctorAvctar;

	public String getDoctorAvctar() {
	    return doctorAvctar;
	}
	
	public void setDoctorAvctar(String doctorAvctar) {
	    this.doctorAvctar = doctorAvctar;
	}
  
}
