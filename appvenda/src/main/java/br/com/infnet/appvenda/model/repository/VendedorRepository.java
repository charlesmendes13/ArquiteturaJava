package br.com.infnet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appvenda.model.domain.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {
	
	List<Vendedor> findAll(Sort sort);
	
	Vendedor findByCpf(String cpf);
}
