package cn.edu.gdin.javaBean;
/**
 * ResponseData
 * @author wufen	
 * @email wufen@163.com
 * @date 2016年12月8日 下午9:33:03
 * @version 1.0
 */
public class ResponseData {
    private Boolean result;
    private String Message;
    private Object data;
    
    public String getMessage() {
        return Message;
    }
    public void setMessage(String message) {
        Message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Boolean getResult() {
        return result;
    }
    public void setResult(Boolean result) {
        this.result = result;
    }
    
}
