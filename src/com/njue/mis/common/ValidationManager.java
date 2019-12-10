/**
 * ��֤����
 */
package com.njue.mis.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ValidationManager
{
	/**
	 * ����null
	 * @param str ������Ķ���
	 * @return ������
	 */
	public static Object changeNull(Object obj)
	{
		if(null==obj)
			return "";
		return obj;
	}
	/**
	 * ��֤�����Ƿ���Ϲ���
	 * @param checkValue ����֤��ʱ���ַ���
	 * @return ��֤���
	 */
	public static boolean validateDate(String checkValue)
	{
		String eL= "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))"; 
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(checkValue);    
        boolean result = m.matches();   
        return result;
	}
	/**
	 * ��֤�ʱ��Ƿ���Ϲ���
	 * @param zip ����֤���ʱ��ַ���
	 * @return ��֤���
	 */
	public static boolean validateZip(String zip)
	{
		String eL= "\\d{6}"; 
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(zip);    
        boolean result = m.matches();   
        return result;
	}
	/**
	 * ��֤�绰�Ƿ���Ϲ���
	 * @param phone ����֤�ĵ绰�ַ���
	 * @return ��֤���
	 */
	public static boolean validatePhone(String phone)
	{
		//String eL= "(\\(\\d{3}\\)|\\d{3}-|\\d{4}-|\\(\\d{4}\\))?\\d{8}";
		String eL= "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(phone);    
        boolean result = m.matches();   
        return result;
	}
	/**
	 * ��֤�����Ƿ���Ϲ���
	 * @param email ����֤�������ַ���
	 * @return ��֤���
	 */
	public static boolean validateEmail(String email)
	{
		String eL= "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"; 
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(email);    
        boolean result = m.matches();   
        return result;
	}
	/**
	 * ��֤�۸��Ƿ���Ϲ���
	 * @param email ����֤�ļ۸��ַ���
	 * @return ��֤���
	 */
	public static boolean validatePrice(String price)
	{
		String eL= "\\d+(.\\d+)?"; 
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(price);    
        boolean result = m.matches();   
        return result;
	}
}
