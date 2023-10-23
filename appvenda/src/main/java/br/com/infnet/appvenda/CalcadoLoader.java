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
import br.com.infnet.appvenda.model.service.CalcadoService;

@Order(2)
@Component
public class CalcadoLoader implements ApplicationRunner {

	@Autowired
	private CalcadoService calcadoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		try (FileReader file = new FileReader("files/calcado.txt");
			    BufferedReader read = new BufferedReader(file)) {
			    String line;

			    while ((line = read.readLine()) != null) {
			        String[] campos = line.split(";");
			        
			        Calcado calcado = new Calcado();
			        calcado.setCodigo(Integer.valueOf(campos[0]));
			        calcado.setDescricao(campos[1]);
			        calcado.setEstoque(Boolean.valueOf(campos[2]));
			        calcado.setPreco(Float.valueOf(campos[3]));
			        calcado.setMarca(campos[4]);
			        calcado.setCor(campos[5]);
			        calcado.setTamanho(Integer.valueOf(campos[6]));
			        
			        calcadoService.incluir(calcado);
			    };
			    
			    read.close();
			    
			    Collection<Calcado> calcados = calcadoService.obterLista();			    
			    calcados.forEach(calcado -> System.out.println("[Calcado] " + calcado));
				
			} catch (IOException e) {
			    e.printStackTrace();
			}		
	}

}
