package cn.edu.gdin.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    private static final String charset = "UTF-8";
    private static final String defaultMimetype = "text/plain";
    
    @Value("${email_seader}")
    private String email_seader ;//="wufenhaoma@sina.com";
    
    @Value("${email_seader_pwd}")
    private String email_seader_pwd ;//="wufen15602383965";
    
   /* public static void main(String[] args) throws Exception {
        EmailSender emailSender = new EmailSender();
        emailSender.send(new String[]{"597354724@qq.com"}, "邮件测试xx", "<b>传智播客</b>", null , "text/html");
    }*/
    /**
     * 发送邮件
     * @param receiver 收件人
     * @param subject 标题
     * @param mailContent 邮件内容
     * @param mimetype 内容类型 默认为text/plain,如果要发送HTML内容,应设置为text/html
     */
    public void send(String receiver, String subject, String mailContent, String mimetype) {
        send(new String[]{receiver}, subject, mailContent, mimetype);
    }
    /**
     * 发送邮件
     * @param receivers 收件人
     * @param subject 标题
     * @param mailContent 邮件内容
     * @param mimetype 内容类型 默认为text/plain,如果要发送HTML内容,应设置为text/html
     */
    public void send(String[] receivers, String subject, String mailContent, String mimetype) {
        send(receivers, subject, mailContent, null, mimetype);
    }
    /**
     * 发送邮件
     * @param receivers 收件人
     * @param subject 标题
     * @param mailContent 邮件内容
     * @param attachements 附件
     * @param mimetype 内容类型 默认为text/plain,如果要发送HTML内容,应设置为text/html
     */
    public void send(String[] receivers, String subject, String mailContent, File[] attachements, String mimetype) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.sina.com");//smtp服务器地址 sohu smtp.qq.com  mail.itcast.cn
        props.put("mail.smtp.auth", "true");//需要校验
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email_seader,email_seader_pwd);//登录用户名 job@itcast.cn/密码 lihuoming
            }
        });
        session.setDebug(true);
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(email_seader));//发件人邮件 job@itcast.cn

            InternetAddress[] toAddress = new InternetAddress[receivers.length];
            for (int i=0; i<receivers.length; i++) {
                toAddress[i] = new InternetAddress(receivers[i]);
            }
            mimeMessage.setRecipients(Message.RecipientType.TO, toAddress);//收件人邮件
            mimeMessage.setSubject(subject, charset);
            
            Multipart multipart = new MimeMultipart();
            //正文
            MimeBodyPart body = new MimeBodyPart();
           // body.setText(message, charset);不支持html
            body.setContent(mailContent, (mimetype!=null && !"".equals(mimetype) ? mimetype : defaultMimetype)+ ";charset="+ charset);
            multipart.addBodyPart(body);//发件内容
            //附件
            if(attachements!=null){
                    for (File attachement : attachements) {
                        MimeBodyPart attache = new MimeBodyPart();
                       //ByteArrayDataSource bads = new ByteArrayDataSource(byte[],"application/x-any");
                        attache.setDataHandler(new DataHandler(new FileDataSource(attachement)));
                        String fileName = getLastName(attachement.getName());
                        attache.setFileName(MimeUtility.encodeText(fileName, charset, null));
                        multipart.addBodyPart(attache);
                    }
            }
            mimeMessage.setContent(multipart);
           // SimpleDateFormat formcat = new SimpleDateFormat("yyyy-MM-dd");            
            mimeMessage.setSentDate(new Date());//formcat.parse("2010-5-23")
            Transport.send(mimeMessage);            
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    private String getLastName(String fileName) {
        int pos = fileName.lastIndexOf("\\");
        if (pos > -1) {
            fileName = fileName.substring(pos + 1);
        }
        pos = fileName.lastIndexOf("/");
        if (pos > -1) {
            fileName = fileName.substring(pos + 1);
        }
        return fileName;
    }
}
