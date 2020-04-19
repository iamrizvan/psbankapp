package com.riz.dev.psbankapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.riz.dev.psbankapp.model.Account;
import com.riz.dev.psbankapp.services.AccountService;
import com.riz.dev.psbankapp.services.AccountServiceImpl;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}

	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}

	@RequestMapping("/new")
	public String showNewPage(Model model) {
		model.addAttribute("account", new Account());
		return "account-form";
	}

	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
//	public String saveAccount(Model model, HttpServletRequest request) // Parameter passed using HTTPServletRequest
	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result) {

		// below required for HttpServletRequest approach.
		/*
		 * String acNo = request.getParameter("accountNo"); String customerName =
		 * request.getParameter("accountHolderName"); String balance =
		 * request.getParameter("balance");
		 */

		/*
		 * model.addAttribute("accountNo",acNo);
		 * model.addAttribute("accountHolderName",customerName);
		 * model.addAttribute("balance",balance);
		 */

		if (result.hasErrors())
			return "account-form";
		else {
			accountService.saveAccount(account);
			return "redirect:/list";
		}
	}
}
