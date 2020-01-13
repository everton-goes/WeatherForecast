package com.teste.web.hbsis.weatherforecast.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrevisaoController {

	@GetMapping("/previsao")
	public ModelAndView previsao() {
		ModelAndView mv = new ModelAndView("previsao/previsao");
		return mv;
	}
}
