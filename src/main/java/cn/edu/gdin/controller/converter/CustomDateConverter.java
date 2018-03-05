package cn.edu.gdin.controller.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * <p>Title: CustomDateConverter</p>
 * <p>Description: 自定义日期转换器</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-20下午5:37:59
 * @version 1.0
 */
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		
		try {
			//进行日期转换
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
