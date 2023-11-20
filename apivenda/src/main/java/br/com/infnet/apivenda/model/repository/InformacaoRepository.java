package br.com.infnet.apivenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.apivenda.model.domain.Informacao;

@Repository
public interface InformacaoRepository extends CrudRepository<Informacao, Integer> {

}
