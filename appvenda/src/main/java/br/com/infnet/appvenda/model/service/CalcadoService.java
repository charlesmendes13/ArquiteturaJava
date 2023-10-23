package br.com.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.infnet.appvenda.model.domain.Calcado;

@Service
public class CalcadoService {

	private Map<Integer, Calcado> mapaCalcado = new HashMap<Integer, Calcado>();
	
	public void incluir(Calcado calcado) {
		mapaCalcado.put(calcado.getCodigo(), calcado);
	}
	
	public Collection<Calcado> obterLista(){	
		return mapaCalcado.values();
	}
}
