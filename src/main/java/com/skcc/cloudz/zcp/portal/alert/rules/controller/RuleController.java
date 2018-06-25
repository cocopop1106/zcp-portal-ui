package com.skcc.cloudz.zcp.portal.alert.rules.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = RuleController.RESOURCE_PATH)
public class RuleController {

	private static final Logger log = LoggerFactory.getLogger(RuleController.class);

	static final String RESOURCE_PATH = "/alert";

	@GetMapping(value = "/rules", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String ruleList(Model model) throws Exception {
		return "content/alert/rules/rules";
	}
	
	@GetMapping(value = "/addRule", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addRule(Model model) throws Exception {
		return "content/alert/rules/addrules";
	}
	
	@GetMapping(value = "/detailRule", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String detailRule(Model model) throws Exception {
		return "content/alert/rules/detailrules";
	}

}
