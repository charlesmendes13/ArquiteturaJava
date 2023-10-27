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

import br.com.infnet.appvenda.model.domain.Roupa;
import br.com.infnet.appvenda.model.domain.Vendedor;
import br.com.infnet.appvenda.model.service.RoupaService;

@Order(3)
@Component
public class RoupaLoader implements ApplicationRunner {

	@Autowired
	private RoupaService roupaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		try (FileReader file = new FileReader("files/roupa.txt");
			    BufferedReader read = new BufferedReader(file)) {
			    String line;

			    while ((line = read.readLine()) != null) {
			        String[] campos = line.split(";");
			        
			        Vendedor vendedor = new Vendedor();
			        Roupa roupa = new Roupa();
			        roupa.setCodigo(Integer.valueOf(campos[0]));
			        roupa.setDescricao(campos[1]);
			        roupa.setEstoque(Boolean.valueOf(campos[2]));
			        roupa.setPreco(Float.valueOf(campos[3]));
			        roupa.setMarca(campos[4]);
			        roupa.setCor(campos[5]);
			        roupa.setTamanho(campos[6]);
			        vendedor.setId(Integer.valueOf(campos[7]));
			        roupa.setVendedor(vendedor);
			        
			        roupaService.incluir(roupa);
			    }
			    
			    read.close();
			    
			    Collection<Roupa> roupas = roupaService.obterLista();			    
			    roupas.forEach(roupa -> System.out.println("[Roupa] " + roupa));
			    
			} catch (IOException e) {
			    e.printStackTrace();
			}
	}

}
