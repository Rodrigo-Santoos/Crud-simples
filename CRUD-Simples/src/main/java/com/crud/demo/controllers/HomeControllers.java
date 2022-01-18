package com.crud.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crud.demo.interfa.PessoaInter;
import com.crud.demo.model.Pessoa;

@Controller
public class HomeControllers {
	
	@Autowired
	private PessoaInter pessoarepositorio;

	@GetMapping("/")
	public ModelAndView index(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/index");
		mv.addObject("pessoa", new Pessoa());
		return mv;
	}
	
	@PostMapping("InsertPessoa")
	public ModelAndView inserindoPessoa(Pessoa pessoa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/pessoas-adicionadas");
		pessoarepositorio.save(pessoa);
		return mv;
	}
	
//	listagem	
	@GetMapping("pessoas-adicionadas")
	public ModelAndView listandoPessoas() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("List/listaPessoas.html");
		mv.addObject("pessoaslist",pessoarepositorio.findAll());
		return mv;
	}
}
