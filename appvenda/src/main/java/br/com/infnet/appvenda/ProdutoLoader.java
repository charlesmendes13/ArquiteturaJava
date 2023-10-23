package br.com.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.infnet.appvenda.model.domain.Calcado;
import br.com.infnet.appvenda.model.domain.Produto;
import br.com.infnet.appvenda.model.domain.Roupa;
import br.com.infnet.appvenda.model.service.ProdutoService;

@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner {

	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try (FileReader file = new FileReader("files/produto.txt");
			    BufferedReader read = new BufferedReader(file)) {
			    String line;

			    while ((line = read.readLine()) != null) {
			        String[] campos = line.split(";");
			        
			        switch (campos[7]) {
			        case "C":
			        	Calcado calcado = new Calcado();
				        calcado.setCodigo(Integer.valueOf(campos[0]));
				        calcado.setDescricao(campos[1]);
				        calcado.setEstoque(Boolean.valueOf(campos[2]));
				        calcado.setPreco(Float.valueOf(campos[3]));
				        calcado.setMarca(campos[4]);
				        calcado.setCor(campos[5]);
				        calcado.setTamanho(Integer.valueOf(campos[6]));
				        
				        produtoService.incluir(calcado);
			        	
			        	break;
			        	
			        case "R":
			        	Roupa roupa = new Roupa();
				        roupa.setCodigo(Integer.valueOf(campos[0]));
				        roupa.setDescricao(campos[1]);
				        roupa.setEstoque(Boolean.valueOf(campos[2]));
				        roupa.setPreco(Float.valueOf(campos[3]));
				        roupa.setMarca(campos[4]);
				        roupa.setCor(campos[5]);
				        roupa.setTamanho(campos[6]);
				        
				        produtoService.incluir(roupa);
			        	
			        	break;
			        	
			        default:
						break;
			        }			        
			    }
			    
			    read.close();
			    
			    Collection<Produto> produtos = produtoService.obterLista();			    
			    produtos.forEach(produto -> System.out.println("[Produto] " + produto));
				
			} catch (IOException e) {
			    e.printStackTrace();
			}
	}

}
