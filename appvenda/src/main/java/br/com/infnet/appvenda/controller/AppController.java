package br.com.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.infnet.appvenda.model.service.CalcadoService;
import br.com.infnet.appvenda.model.service.ProdutoService;
import br.com.infnet.appvenda.model.service.RoupaService;
import br.com.infnet.appvenda.model.service.InformacaoService;
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
	
	@Autowired
	private InformacaoService informacaoService;	
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("informacoes", informacaoService.obterLista());		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeCalcado", calcadoService.obterQtde());
		model.addAttribute("qtdeRoupa", roupaService.obterQtde());

		return "home";
	}
}