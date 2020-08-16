package com.gqgx.utils;

import javax.servlet.http.HttpSession;



public class SessionUtils 
{
	public static String SESSION_KEY="user";
	
	public static String USER_COOKIE="user_cookie";

	public static Object getUserInfo()
	{
		HttpSession session = getCurrentSession();
		if(session==null){
			return null;
		}
		return  session.getAttribute(SESSION_KEY);
	}
	
	public static HttpSession getCurrentSession()
	{
		HttpSession session =WebUtils.getHttpSession();
		return session;
	}
	
	public static void saveUserInfo(Object customer)
	{
		HttpSession session = getCurrentSession();
		session.setAttribute(SESSION_KEY, customer);
	}
	
	
}
