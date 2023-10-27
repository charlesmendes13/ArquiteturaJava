package br.com.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appvenda.model.domain.Calcado;
import br.com.infnet.appvenda.model.repository.CalcadoRepository;

@Service
public class CalcadoService {
	
	@Autowired
	private CalcadoRepository calcadoRepository;
		
	public void incluir(Calcado calcado) {
		calcadoRepository.save(calcado);
	}
	
	public Collection<Calcado> obterLista(){	
		return (Collection<Calcado>) calcadoRepository.findAll();
	}
}
