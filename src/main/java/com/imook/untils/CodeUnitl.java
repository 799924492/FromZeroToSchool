package com.imook.untils;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;
//CodeUnitl.checkVerifyCode(request)   为true

//verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)   为false
//verifyCodeActual.equals(verifyCodeExpected) 为true
public class CodeUnitl {
    public static boolean checkVerifyCode(HttpServletRequest request) {

        // 获取图片中的校验码
        String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 获取输入的校验码
        String verifyCodeActual = HttpServiletRequestUntils.getString(request, "verifyCodeActual");
        // 比较 如果有1个true 就进来了
        //  1. verifyCodeActual==null; false
        //2. !verifyCodeActual.equals(verifyCodeExpected) 为false   2个不相等
        if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
