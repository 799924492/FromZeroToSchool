package com.imook.untils;

import javax.servlet.http.HttpServletRequest;

public class HttpServiletRequestUntils {
    //负责处理httpservietrequest 参数
    public static int getInt(HttpServletRequest request, String key) {
        try {
            //  讲Key转换成整形
            return Integer.decode(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static Long getLong(HttpServletRequest request, String key) {
        try {
            //  讲Key转换成整形
            return Long.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static Double getDouble(HttpServletRequest request, String key) {
        try {
            //  讲Key转换成整形
            return Double.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1d;
        }
    }

    public static Boolean getBoolean(HttpServletRequest request, String key) {
        try {
            //  讲Key转换成整形
            return Boolean.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if (result != null) {
                result = result.trim();
            }
            if (request.equals(""))
            {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
