package com.des.site.controller;

import com.des.site.util.AppConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import static com.des.site.util.AppConstants.staticPagesList;

@Controller
public class HomeController {

    static {
        if(staticPagesList.size() <= 0){
            staticPagesList.add("/about.html");
            staticPagesList.add("/book-service.html");
            staticPagesList.add("/building-service.html");
            staticPagesList.add("/career.html");
            staticPagesList.add("/contact.html");
            staticPagesList.add("/financial-service.html");
            staticPagesList.add("/it-service.html");
            staticPagesList.add("/janitoral-service.html");
            staticPagesList.add("/landscaping-service.html");
            staticPagesList.add("/price.html");
            staticPagesList.add("/repair-service.html");

        }
    }
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home (HttpServletRequest request, HttpServletResponse response) {
        return AppConstants.HOME_PAGE;
    }
}
