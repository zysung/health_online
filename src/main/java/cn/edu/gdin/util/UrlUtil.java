package cn.edu.gdin.util;

import java.io.UnsupportedEncodingException;

/**
 * url转码、解码
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月9日 上午12:43:20
 * @version 1.0
 */
public class UrlUtil {

        private final static String ENCODE = "GBK"; 
        /**
         * URL 解码
         *
         * @return String
         * @author lifq
         * @date 2015-3-17 下午04:09:51
         */
        public static String getURLDecoderString(String str) {
            String result = "";
            if (null == str) {
                return "";
            }
            try {
                result = java.net.URLDecoder.decode(str, ENCODE);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return result;
        }
        /**
         * URL 转码
         *
         * @return String
         * @author lifq
         * @date 2015-3-17 下午04:10:28
         */
        public static String getURLEncoderString(String str) {
            String result = "";
            if (null == str) {
                return "";
            }
            try {
                result = java.net.URLEncoder.encode(str, ENCODE);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return result;
        }

        /**
         * 
         * @return void
         * @author lifq
         * @date 2015-3-17 下午04:09:16
         */
        public static void main(String[] args) {
            String str = "测试1";
            System.out.println(getURLEncoderString(str));
            System.out.println(getURLDecoderString(str));
            
        }
}
