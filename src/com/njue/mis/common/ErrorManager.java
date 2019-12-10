/**
 * 错误处理类
 */
package com.njue.mis.common;

public abstract class ErrorManager
{
	/**
	 * 输出错误信息
	 * @param name 使用该方法的类名+方法名
	 * @param e 错误对象
	 */
	public static void printError(String name,Exception e)
	{
		System.out.println(name+" Error!"+e.getMessage());
		e.printStackTrace();
	}
}
