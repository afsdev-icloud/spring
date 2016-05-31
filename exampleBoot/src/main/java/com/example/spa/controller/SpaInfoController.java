package com.example.spa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spa.entity.SpaDataDto;
import com.example.spa.form.SpaInfoForm;
import com.example.spa.service.SpaDataService;

/**
 * 温泉情報検索 Controller class
 */
@Controller
@RequestMapping("/SpaInfo")
public class SpaInfoController {

    @Autowired
    private SpaDataService spaDataService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/**
	 * 検索画面の表示
	 *
	 * @param form  条件入力画面
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(SpaInfoForm form, Model model) {
	    return "index";
	}

	/**
	 * 項目チェック結果の確認、DB検索、検索結果の表示
	 *
	 * @param form   条件入力画面
	 * @param result 項目チェック結果
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String confirm(@Validated @ModelAttribute SpaInfoForm form, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	      model.addAttribute("validationError", "入力内容が不正です。");
	      return index(form, model);
	    }

		List<SpaDataDto> spaData = spaDataService.searchSpaData(form.getSpaGroup());

		if (1 > spaData.size()) {
		    model.addAttribute("validationError", "該当するデータはありません。");
		    return index(form, model);
		}

        model.addAttribute("spaInfo", spaData);
	    return "SpaInfo/list";
	}

	/**
	 * 温泉情報の詳細表示
	 *
	 * @param spaGroup 温泉地
	 * @param spaName  施設名
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{spaGroup}/{spaName}", method = RequestMethod.GET)
	public String detail(@PathVariable("spaGroup") String spaGroup,
						@PathVariable("spaName") String spaName, Model model) {

		SpaDataDto spaData = spaDataService.selectSpaData(spaGroup, spaName);

        model.addAttribute("spaInfo", spaData);
	    return "SpaInfo/detail";
	}

}
