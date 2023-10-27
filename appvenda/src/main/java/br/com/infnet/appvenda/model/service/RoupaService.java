package br.com.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appvenda.model.domain.Roupa;
import br.com.infnet.appvenda.model.repository.RoupaRepository;

@Service
public class RoupaService {

	@Autowired
	private RoupaRepository roupaRepository;
		
	public void incluir(Roupa roupa) {
		roupaRepository.save(roupa);		
	}
	
	public Collection<Roupa> obterLista(){	
		return (Collection<Roupa>) roupaRepository.findAll();		
	}
}
