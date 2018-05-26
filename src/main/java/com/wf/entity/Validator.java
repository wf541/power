package com.wf.entity;

import java.util.regex.Pattern;

public class Validator {
	 /** 
     * 正则表达式：验证用户名 
     */  
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";  
   
    /** 
     * 正则表达式：验证密码 
     */  
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";  
   
    /** 
     * 正则表达式：验证手机号 
     */  
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0])|(17[7])|(18[0,0-9]))\\d{8}$";  
   
    /** 
     * 正则表达式：验证邮箱 
     */  
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
   
    /** 
     * 正则表达式：验证身份证 
     */  
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";  
   
    /** 
     * 校验用户名 
     * 
     * @param username 
     * @return 校验通过返回true，否则返回false 
     */  
    public static boolean isUsername(String username) {  
        return Pattern.matches(REGEX_USERNAME, username);  
    }  
   
    /** 
     * 校验密码 
     * 
     * @param password 
     * @return 校验通过返回true，否则返回false 
     */  
    public static boolean isPassword(String password) {  
        return Pattern.matches(REGEX_PASSWORD, password);  
    }  
   
    /** 
     * 校验手机号 
     * 
     * @param mobile 
     * @return 校验通过返回true，否则返回false 
     */  
    public static boolean isMobile(String mobile) {  
        return Pattern.matches(REGEX_MOBILE, mobile);  
    }  
   
    /** 
     * 校验邮箱 
     * 
     * @param email 
     * @return 校验通过返回true，否则返回false 
     */  
    public static boolean isEmail(String email) {  
        return Pattern.matches(REGEX_EMAIL, email);  
    }  
   
   
    /** 
     * 校验身份证 
     * 
     * @param idCard 
     * @return 校验通过返回true，否则返回false 
     */  
    public static boolean isIDCard(String idCard) {  
        return Pattern.matches(REGEX_ID_CARD, idCard);  
    }  
}
