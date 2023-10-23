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

import br.com.infnet.appvenda.model.domain.Vendedor;
import br.com.infnet.appvenda.model.service.VendedorService;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {

	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try (FileReader file = new FileReader("files/vendedor.txt");
			    BufferedReader read = new BufferedReader(file)) {
			    String line;

			    while ((line = read.readLine()) != null) {
			        String[] campos = line.split(";");
			        
			        Vendedor vendedor = new Vendedor();
			        vendedor.setNome(campos[0]);
			        vendedor.setCpf(campos[1]);
			        vendedor.setEmail(campos[2]);
			        
			        vendedorService.incluir(vendedor);
			    }
			    
			    read.close();
			    
			    Collection<Vendedor> vendedores = vendedorService.obterLista();			    
			    vendedores.forEach(vendedor -> System.out.println("[Vendedor] " + vendedor)); 
				
			} catch (IOException e) {
			    e.printStackTrace();
			}
		
	}

}
