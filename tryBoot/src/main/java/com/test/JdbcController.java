package com.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Jdbc")
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbc;

	@RequestMapping(method = RequestMethod.GET)
    public String getJdbc(Model model) {

        List<Map<String, Object>> list = this.jdbc.queryForList("SELECT * FROM person");
        list.forEach(System.out::println);

        model.addAttribute("persons", list);
        return "list";
    }
	// Id Name
	// 1  佐藤
	// 2  鈴木

}
