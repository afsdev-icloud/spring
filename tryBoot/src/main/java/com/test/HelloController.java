package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(name = "/", method = RequestMethod.GET)
    public String sayHello(Model model) {
        logger.info("* Hello ");

        model.addAttribute("message", "こんにちは世界");
        return "index";
    }

    @RequestMapping(name = "/", method = RequestMethod.POST)
    public String createHelloMessage(@RequestParam("name") String name, Model model) {
        logger.info("* Hello: " + name);

        model.addAttribute("message", "こんにちは " + name + " さん !");
        return "index";
    }

}
