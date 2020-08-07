package util;

import javax.servlet.http.HttpServletRequest;

public class MyUtils {
	
    //获取ip地址
	public static String getIpAddress(HttpServletRequest request) {
		 String ipAddress = request.getHeader("x-forwarded-for");
	     if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	    	 ipAddress = request.getHeader("Proxy-Client-IP");
	     }
	     if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	    	 ipAddress = request.getHeader("WL-Proxy-Client-IP");
	     }
	     if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
	         //HttpServletRequest的这个方法能够获取ip地址
	    	 ipAddress = request.getRemoteAddr();
	     }
	     //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
	     if (ipAddress != null && ipAddress.length() > 15) {
	         if (ipAddress.indexOf(",") > 0) {
	             ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
	         }
	     }
	     return ipAddress;
	}
	
}