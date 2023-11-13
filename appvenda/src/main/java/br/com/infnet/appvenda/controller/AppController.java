package br.com.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.appvenda.model.service.CalcadoService;
import br.com.infnet.appvenda.model.service.ProdutoService;
import br.com.infnet.appvenda.model.service.RoupaService;
import br.com.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private RoupaService roupaService;
	
	@Autowired
	private CalcadoService calcadoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeRoupa", roupaService.obterQtde());
		model.addAttribute("qtdeCalcado", calcadoService.obterQtde());

		return "home";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("titulo", "Produtos:");
		model.addAttribute("listagem", produtoService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/roupa/lista")
	public String obterListaRoupa(Model model) {
		
		model.addAttribute("titulo", "Produtos Roupa:");
		model.addAttribute("listagem", roupaService.obterLista());

		return showHome(model);
	}

	@GetMapping(value = "/calcado/lista")
	public String obterListaCalcado(Model model) {
		
		model.addAttribute("titulo", "Produtos Calçado:");
		model.addAttribute("listagem", calcadoService.obterLista());

		return showHome(model);
	}
}