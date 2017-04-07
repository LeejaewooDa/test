package com.mycompany.helper;

import javax.servlet.http.HttpServletRequest;

public class URLHelper {
    public static String baseUrl(String uri, HttpServletRequest request) {
        return request.getScheme() + "://" // http://
                + request.getServerName() // domain.com
                +":" + request.getServerPort() // :8080
                + request.getContextPath() + uri; // myapp/uri
    }
}