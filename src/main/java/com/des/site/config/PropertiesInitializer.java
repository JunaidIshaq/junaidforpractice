package com.des.site.config;


import com.des.site.util.AppConstants;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PropertiesInitializer {

    @PostConstruct
    public void init(){
        populateApplicationProperties();
    }

    private void populateApplicationProperties() {
        AppConstants.HOME_PAGE = "/index.html";
    }
}
