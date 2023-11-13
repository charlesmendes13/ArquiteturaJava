package br.com.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.appvenda.model.domain.Produto;
import br.com.infnet.appvenda.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
		
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public Collection<Produto> obterLista(Integer idVendedor){
		return (Collection<Produto>) produtoRepository.obterLista(idVendedor);
	}
	
	public long obterQtde() {
		return produtoRepository.count();
	}
}
