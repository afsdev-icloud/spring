package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Param1")
public class Param1Controller {

	@RequestMapping(value = "/{namae}", method = RequestMethod.GET)
    public String sayName(Model model, @PathVariable String namae) {
        model.addAttribute("message", "こんにちは " + namae + " さん !");
        return "param";
    }
	// http://localhost:8080/Param1/田中
	//
	//  こんにちは 田中 さん !

}
