package br.com.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.appvenda.model.service.RoupaService;

@Controller
public class RoupaController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private RoupaService roupaService;


	@GetMapping(value = "/roupa/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		roupaService.excluir(id);
		
		return "redirect:/roupa/lista";
	}
	
	@GetMapping(value = "/roupa/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("rota", "roupa");
		model.addAttribute("titulo", "Roupas:");
		model.addAttribute("listagem", roupaService.obterLista());

		return appController.showHome(model);
	}
}
