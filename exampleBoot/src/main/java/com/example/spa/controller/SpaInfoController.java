package com.example.spa.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.spa.service.StateMastService;

/**
 * 温泉情報検索 Controller class
 */
@Controller
@RequestMapping("/SpaInfo")
public class SpaInfoController {

    private static final Logger logger = LoggerFactory.getLogger(SpaInfoController.class);

    @Autowired
    private SpaDataService spaDataService;

    @Autowired
    private StateMastService stateMastService;

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
        logger.info("* index - / ");

        Map<String, String> stateItems = stateMastService.getStateItems();
        model.addAttribute("stateItems", stateItems);

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
	public String check(@Validated @ModelAttribute SpaInfoForm form, BindingResult result, Model model) {
        logger.info("* check - /list " + form.toString());

	    if (result.hasErrors()) {
	      model.addAttribute("validationError", "入力内容が不正です。");
	      return index(form, model);
	    }

	    List<SpaDataDto> spaData =null;
	    if (form.getSpaGroup() == null) {
	    	spaData = spaDataService.searchByState(form.getStateCd());
	    } else {
	    	spaData = spaDataService.searchByStateGroup(form.getStateCd(), form.getSpaGroup());
	    }

		if (1 > spaData.size()) {
		    model.addAttribute("validationError", "該当するデータはありません。");
		    return index(form, model);
		}

        model.addAttribute("spaInfo", spaData);
	    if (form.getSpaGroup() == null) {
	        model.addAttribute("key", "1");
	    } else {
	        model.addAttribute("key", "2");
	    }
	    return "SpaInfo/list";
	}

	/**
	 * 温泉情報の一覧表示(back)
	 *
	 * @param stateCd  県コード
	 * @param spaGroup 温泉地
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list/{key}/{stateCd}/{spaGroup}", method = RequestMethod.GET)
	public String list(@PathVariable("key") String key,
						@PathVariable("stateCd") String stateCd,
			            @PathVariable("spaGroup") String spaGroup, Model model) {
        logger.info("* list - /" + spaGroup);

        List<SpaDataDto> spaData = null;
        if (key.equals("1")) {
        	spaData = spaDataService.searchByState(stateCd);
        } else {
        	spaData = spaDataService.searchByStateGroup(stateCd, spaGroup);
        }

        model.addAttribute("spaInfo", spaData);
        model.addAttribute("key", key);
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
	@RequestMapping(value = "/{key}/{spaGroup}/{spaName}", method = RequestMethod.GET)
	public String detail(@PathVariable("key") String key,
						@PathVariable("spaGroup") String spaGroup,
						@PathVariable("spaName") String spaName, Model model) {
        logger.info("* detail - /" + spaGroup + "/" + spaName);

		SpaDataDto spaData = spaDataService.selectSpaData(spaGroup, spaName);

        model.addAttribute("spaInfo", spaData);
        model.addAttribute("stateCd", spaData.getStateCd());
        if (key.equals("1")) {
            model.addAttribute("spaGroup", "-");
        } else {
            model.addAttribute("spaGroup", spaData.getSpaGroup());
        }
        model.addAttribute("key", key);
	    return "SpaInfo/detail";
	}

}
