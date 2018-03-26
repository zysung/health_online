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
public class StringTrimConverter implements Converter<String, String> {

	public String convert(String source) {
		
		try {
			//去掉字符串两边空格，如果去除后为空设置为null
			if(source!=null){
				source = source.trim();
				if(source.equals("")){
					return null;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return source;
	}

}
