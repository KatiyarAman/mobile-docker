package com.mobiledocker.mobiledocker.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class PageCntroller {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PageCntroller.class);

    @RequestMapping(value = "/about", method = {RequestMethod.GET, RequestMethod.POST})
    public String gallery() {
        log.info("Page gallery controller :");
        return "about";
    }

    @RequestMapping(value = "/product", method = {RequestMethod.GET, RequestMethod.POST})
    public String basicgrid() {
        log.info("Page Basic Grid controller:");
        return "product";
    }

    @RequestMapping(value = "/blog", method = {RequestMethod.GET, RequestMethod.POST})
    public String fontsIcons() {
        log.info("Page fonts-icons Controller :");
        return "blog";
    }

    @RequestMapping(value = "/contact", method = {RequestMethod.GET, RequestMethod.POST})
    public String fullWidth() {
        log.info("Page full-width Controller :");
        return "contact";
    }

    @RequestMapping(value = "/sidebar-left", method = {RequestMethod.GET, RequestMethod.POST})
    public String sideBarLeft() {
        log.info("Page sidebar-left Controller :");
        return "sidebar-left";
    }

    @RequestMapping(value = "/sidebar-right", method = {RequestMethod.GET, RequestMethod.POST})
    public String sidebarRight() {
        log.info("Page side-bar right controller :");
        return "sidebar-right";
    }
}
