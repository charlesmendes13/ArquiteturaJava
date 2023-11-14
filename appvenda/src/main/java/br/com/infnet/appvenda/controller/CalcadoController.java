package br.com.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.appvenda.model.service.CalcadoService;

@Controller
public class CalcadoController {
	
	@Autowired
	private AppController appController;
	
	@Autowired
	private CalcadoService calcadoService;


	@GetMapping(value = "/calcado/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		calcadoService.excluir(id);
		
		return "redirect:/calcado/lista";
	}
	
	@GetMapping(value = "/calcado/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("rota", "calcado");
		model.addAttribute("titulo", "Calcados:");
		model.addAttribute("listagem", calcadoService.obterLista());

		return appController.showHome(model);
	}
}
