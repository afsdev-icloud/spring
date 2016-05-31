package com.example.spa.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spa.entity.SpaDataDto;
import com.example.spa.form.SpaRegistForm;
import com.example.spa.service.SpaDataService;

/**
 * 温泉情報更新 Controller class
 */
@Controller
@RequestMapping("/SpaRegist")
public class SpaRegistController {

    @Autowired
    private SpaDataService spaDataService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * 登録画面の表示
	 *
	 * @param form  登録画面
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(SpaRegistForm form, Model model) {
	    return "SpaRegist/index";
	}

	/**
	 * 項目チェック結果の確認、DB更新、更新内容の表示
	 *
	 * @param form   登録画面
	 * @param result 項目チェック結果
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String confirm(@Validated @ModelAttribute SpaRegistForm form, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        model.addAttribute("validationError", "入力内容が不正です。");
	        return index(form, model);
	    }

	    SpaDataDto spaData = new SpaDataDto();

	    BeanUtils.copyProperties(form, spaData);

	    spaDataService.insertSpaData(spaData);

	    return "SpaRegist/confirm";
	}

}
