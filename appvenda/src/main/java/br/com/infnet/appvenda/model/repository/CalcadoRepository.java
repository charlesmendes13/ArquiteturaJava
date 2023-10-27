package br.com.infnet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.appvenda.model.domain.Calcado;

@Repository
public interface CalcadoRepository extends CrudRepository<Calcado, Integer> {

}
