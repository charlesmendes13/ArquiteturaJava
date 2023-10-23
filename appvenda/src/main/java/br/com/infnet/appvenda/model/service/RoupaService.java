package br.com.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.infnet.appvenda.model.domain.Roupa;

@Service
public class RoupaService {

	private Map<Integer, Roupa> mapaRoupa = new HashMap<Integer, Roupa>();
	
	public void incluir(Roupa roupa) {
		mapaRoupa.put(roupa.getCodigo(), roupa);
	}
	
	public Collection<Roupa> obterLista(){	
		return mapaRoupa.values();
	}
}
