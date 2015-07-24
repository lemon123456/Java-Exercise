package com.tw.core.Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void saveCookie(String cookieName, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static String getCookie(String cookieName, HttpServletRequest request) {
        String cookieValue = null;
        Cookie[] cookies = request.getCookies();
        Cookie c = null;

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                c = cookies[i];
                if (c.getName().equals(cookieName)) {
                    cookieValue = c.getValue();
                }
            }
        }
        return cookieValue;
    }

    public static void deleteCookie( HttpServletRequest request,HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie c = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                c = cookies[i];
                if (c != null) {
                    c.setMaxAge(0);
                    c.setPath("/");
                    response.addCookie(c);
                }
            }
        }
    }
}
