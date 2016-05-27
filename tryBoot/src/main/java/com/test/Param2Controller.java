package com.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Param2")
public class Param2Controller {

	@RequestMapping(method = RequestMethod.GET)
    public String sayName(Model model,
    		@RequestParam Map<String, String> queryParameters,
    		@RequestParam MultiValueMap<String, String> multiMap) {

		System.out.println(queryParameters);
		System.out.println(multiMap);

        model.addAttribute("message", multiMap);
        return "param";
    }
	// http://localhost:8080/Param2?code=STS11&code=SVN21
	//
	//  {code=[STS11, SVN21]}

}
