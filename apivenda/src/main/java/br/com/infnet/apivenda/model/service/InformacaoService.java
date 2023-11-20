package br.com.infnet.apivenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.apivenda.model.domain.Informacao;
import br.com.infnet.apivenda.model.repository.InformacaoRepository;

@Service
public class InformacaoService {

	@Autowired
	private InformacaoRepository informacaoRepository;

	public List<Informacao> obterLista() {
		return (List<Informacao>) informacaoRepository.findAll();
	}

	public Informacao incluir(Informacao informacao) {
		return informacaoRepository.save(informacao);
	}
}
