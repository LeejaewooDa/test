package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        // 기존 "home.jsp"에서 변경
        // */* 형태로 페이지를 요청하였으므로,
        // tiles.xml 설정에 의해 content로 전송 됨.
        return "statics/home";
    }
}
