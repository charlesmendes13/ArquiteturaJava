package br.com.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.infnet.appvenda.model.domain.Vendedor;

@Service
public class VendedorService {

	private Map<String, Vendedor> mapaVendedor = new HashMap<String, Vendedor>();

	public void incluir(Vendedor vendedor) {
		mapaVendedor.put(vendedor.getCpf(), vendedor);
	}
	
	public Collection<Vendedor> obterLista(){	
		return mapaVendedor.values();
	}
}
